package be.helb.PierrePlay.services;

import be.helb.PierrePlay.models.Game;
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

    public Game getById(Long id) { return gameDao.findById(id).orElse(null); }

    public List<Game> getByRating(Integer pegi) {
        return gameDao.findByPegi(pegi);
    }

    public List<Game> getByTitle(String title) { return gameDao.findByTitle(title); }

    public Game save(Game game) { return gameDao.save(game); }

    public void delete(Game game) { gameDao.delete(game); }

    public void update(Game game) { gameDao.save(game); }
}
