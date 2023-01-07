package be.helb.PierrePlay.controllers;

import be.helb.PierrePlay.models.Game;
import be.helb.PierrePlay.services.GameService;
import be.helb.PierrePlay.models.Game;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
import java.util.List;
import java.util.Optional;

@RestController
public class GameController
{
    @Autowired
    private GameService gameService;

    @GetMapping("games")
    public List<Game> gameList(@RequestParam(required = false) String title, @RequestParam(required = false) Integer pegi)
    {
        if (title != null) return gameService.getByTitle(title);
        if (pegi != null) return gameService.getByRating(pegi);
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
            gameService.save(game);
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
