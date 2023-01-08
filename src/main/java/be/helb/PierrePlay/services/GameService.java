package be.helb.PierrePlay.services;

import be.helb.PierrePlay.daos.OwnsGameDao;
import be.helb.PierrePlay.models.Game;
import be.helb.PierrePlay.daos.GameDao;

import be.helb.PierrePlay.models.OwnsGame;
import be.helb.PierrePlay.models.User;
import be.helb.PierrePlay.models.keys.OwnsGameKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class GameService {

    private GameDao gameDao;
    private OwnsGameDao ownsGameDao;

    @Autowired
    public GameService(GameDao gameDao, OwnsGameDao ownsGameDao) {
        this.gameDao = gameDao;
        this.ownsGameDao = ownsGameDao;
    }

    public GameDao getGameDao() { return gameDao; }

    public void setGameDao(GameDao gameDao) { this.gameDao = gameDao; }

    public List<Game> getAll() { return gameDao.findAll(); }

    public Game getById(Long id) { return gameDao.findById(id).orElse(null); }

    public List<Game> getByRating(Integer pegi) {
        return gameDao.findByPegi(pegi);
    }

    public List<Game> search(String title) { return gameDao.findByTitleContainsIgnoreCase(title); }

    public List<Game> getUserGames(Collection<Long> ids) { return gameDao.findByGameIdIn(ids); }

    public void buyGame(Game game, User user)
    {
        OwnsGame own = new OwnsGame();
        own.setGame(game);
        own.setUser(user);
        own.setId(new OwnsGameKey(user.getUserId(), game.getGameId()));
        ownsGameDao.save(own);
    }

    public Game save(Game game) { return gameDao.save(game); }

    public void delete(Game game) { gameDao.delete(game); }

    public void update(Game game) { gameDao.save(game); }
}
