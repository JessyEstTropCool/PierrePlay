package be.helb.PierrePlay.controllers;

import be.helb.PierrePlay.services.GameService;
import be.helb.PierrePlay.models.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        if (pegi != null) return gameService.getByRating(pegi, null, null);
        return gameService.getAll();
    }

    @GetMapping("games/{id}")
    public Optional<Game> gameById(@PathVariable long id) {
        return gameService.getById(id);
    }

    @GetMapping("games/rating")
    public List<Game> gameList(@RequestParam(required = false) Integer pegi, @RequestParam(required = false) String esrb, @RequestParam(required = false) String cero)
    {
        return gameService.getByRating(pegi, esrb, cero);
    }

    @PostMapping(path="/add") // Map ONLY POST Requests
    public @ResponseBody String addNewGame(@RequestParam String name, @RequestParam String esrb) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        Game n = new Game();
        n.setTitle(name);
        n.setEsrb(esrb);
        gameService.save(n);
        return n.toString();
    }
}
