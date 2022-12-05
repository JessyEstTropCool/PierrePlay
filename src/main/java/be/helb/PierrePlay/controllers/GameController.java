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
}
