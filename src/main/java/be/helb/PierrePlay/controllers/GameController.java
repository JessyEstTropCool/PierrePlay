package be.helb.PierrePlay.controllers;

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

    @PostMapping(path="games/add") // Map ONLY POST Requests
    public @ResponseBody String addNewGame(@RequestParam String name, @RequestParam Integer pegi) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        Game n = new Game();
        n.setTitle(name);
        n.setPegi(pegi);
        gameService.save(n);
        return n.toString();
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
