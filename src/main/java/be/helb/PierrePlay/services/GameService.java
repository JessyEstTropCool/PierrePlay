package be.helb.PierrePlay.services;

import be.helb.PierrePlay.models.Game;
import be.helb.PierrePlay.daos.GameDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GameService {

    @Autowired
    private GameDao gameDao;

    public GameService(GameDao gameDao) {
        this.gameDao = gameDao;
    }

    public GameDao getGameDao() { return gameDao; }

    public void setGameDao(GameDao gameDao) { this.gameDao = gameDao; }

    public List<Game> getAll() { return gameDao.findAll(); }

    public Optional<Game> getById(Long id) { return gameDao.findById(id); }

    public List<Game> getByRating(Integer pegi, String esrb, String cero) {
        if (pegi != null) return gameDao.findByPegi(pegi);
        if (esrb != null) return gameDao.findByEsrb(esrb);
        if (cero != null) return gameDao.findByCero(cero);
        else return new ArrayList<Game>();
    }

    public List<Game> getByTitle(String title) { return gameDao.findByTitle(title); }

    public void save(Game game) { gameDao.save(game); }
}
