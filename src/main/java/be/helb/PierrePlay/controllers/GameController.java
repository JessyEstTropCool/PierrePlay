package be.helb.PierrePlay.controllers;

import be.helb.PierrePlay.models.Game;
import be.helb.PierrePlay.models.OwnsGame;
import be.helb.PierrePlay.models.User;
import be.helb.PierrePlay.services.CompanyService;
import be.helb.PierrePlay.services.GameService;
import be.helb.PierrePlay.models.Game;
import be.helb.PierrePlay.services.UserService;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class GameController
{
    private GameService gameService;
    private UserService userService;

    @Autowired
    public GameController(GameService gameService, UserService userService)
    {
        this.gameService = gameService;
        this.userService = userService;
    }

    @GetMapping("games")
    public List<Game> gameList(@RequestParam(required = false) String title)
    {
        if (title != null) return gameService.search(title);
        return gameService.getAll();
    }

    @GetMapping("games/{id}")
    public Game gameById(@PathVariable long id) {
        return gameService.getById(id);
    }

    @GetMapping("games/rating/{pegi}")
    public List<Game> gameList(@PathVariable Integer pegi)
    {
        return gameService.getByRating(pegi);
    }

    @GetMapping("games/user")
    public List<Game> userGames()
    {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = (String) auth.getPrincipal();
        User user = userService.getByUsername(username);
        List<Long> ids = new ArrayList<Long>();

        for (OwnsGame own : user.getOwnedGames())
        {
            ids.add(own.getId().getGameId());
        }

        return gameService.getUserGames(ids);
    }

    @GetMapping("games/buy/{id}")
    public List<Game> buyGame(@PathVariable Long id)
    {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = (String) auth.getPrincipal();
        User user = userService.getByUsername(username);
        Game game = gameService.getById(id);



        gameService.buyGame(game, user);

        return userGames();
    }

    @PostMapping(path="games/add")
    public Game addGame(@RequestBody Game game) {
        game.setGameId(null);
        gameService.save(game);
        return game;
    }

    @DeleteMapping(path="games/{id}")
    public @ResponseBody String deleteGame(@PathVariable long id) {
        Game game = gameService.getById(id);

        if ( game != null )
        {
            gameService.delete(game);
            return "Delete Successfully";
        }
        else throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Game not found");
    }

    @PutMapping(path="games/{id}")
    public Game updateGame(@PathVariable long id, @RequestBody Game game) {
        game.setGameId(id);
        if (gameService.getById(id) != null)
        {
            gameService.update(game);
            return game;
        }
        else throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Game not found");
    }

    @PostMapping(path="/games/{id}/boxart/set", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Long> setBoxart(@PathVariable long id, @RequestPart("file") MultipartFile multipartFile) throws IOException, SQLException, URISyntaxException {
        Game game = gameService.getById(id);
        if (game != null)
        {
            game.setBoxartName(multipartFile.getOriginalFilename());
            game.setBoxart(multipartFile.getInputStream().readAllBytes());
            gameService.save(game);
        }

        return ResponseEntity.created(new URI("http://localhost:8080/games/" + id)).build();
    }

    @GetMapping(path="/games/{id}/boxart")
    public void getBoxart(@PathVariable long id, HttpServletResponse response) throws SQLException, IOException {
        Game game = gameService.getById(id);

        if (game != null)
        {
            response.addHeader("Content-Disposition", "attachment; filename=" + game.getBoxartName());
            IOUtils.copy(new ByteArrayInputStream(game.getBoxart()), response.getOutputStream());
        }
        else
        {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "game not found"
            );
        }
    }
}
