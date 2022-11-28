package be.helb.PierrePlay.controllers;

import be.helb.PierrePlay.daos.GameDao;
import be.helb.PierrePlay.models.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class GameController
{
    @Autowired
    private GameDao gameDao;

    @GetMapping("games")
    public List<Game> gameList(@RequestParam(required = false) String title, @RequestParam(required = false) Integer pegi)
    {
        if (title != null) return gameDao.findByTitle(title);
        if (pegi != null) return gameDao.findByPegi(pegi);
        return gameDao.findAll();
    }

    @GetMapping("games/{id}")
    public Optional<Game> gameById(@PathVariable long id) {
        return gameDao.findById(id);
    }

    @GetMapping("games/rating")
    public List<Game> gameList(@RequestParam(required = false) Integer pegi, @RequestParam(required = false) String esrb, @RequestParam(required = false) String cero)
    {
        if (pegi != null) return gameDao.findByPegi(pegi);
        if (esrb != null) return gameDao.findByEsrb(esrb);
        if (cero != null) return gameDao.findByCero(cero);
        return gameDao.findAll();
    }
}
