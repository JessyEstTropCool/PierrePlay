package be.helb.PierrePlay.services;

import be.helb.PierrePlay.daos.GameDao;
import be.helb.PierrePlay.daos.OwnsGameDao;
import be.helb.PierrePlay.daos.UserDao;
import be.helb.PierrePlay.models.Game;
import be.helb.PierrePlay.models.OwnsGame;
import be.helb.PierrePlay.models.User;
import org.easymock.EasyMock;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameServiceTest
{
    private GameDao gameDao;
    private OwnsGameDao ownsGameDao;
    private GameService gameService;

    @Test
    public void testGetAllGames()
    {
        List<Game> games = List.of(new Game("Game 1"),new Game("Game 2"),new Game("Game 3"));

        gameDao = EasyMock.mock(GameDao.class);

        EasyMock.expect(gameDao.findAll()).andReturn(games);

        gameService = new GameService(gameDao, ownsGameDao);
        EasyMock.replay(gameDao);
        int result = gameService.getAll().size();
        assertEquals(3, result);
        EasyMock.verify(gameDao);
    }

    @Test
    public void testSearchGames()
    {
        List<Game> games = List.of(new Game("Cool Game 1"),new Game("coolGame 2"),new Game("Game 3"));
        List<Game> searchResult = games.subList(0, 2);

        gameDao = EasyMock.mock(GameDao.class);
        EasyMock.expect(gameDao.findByTitleContainsIgnoreCase("cool")).andReturn(searchResult);
        EasyMock.expect(gameDao.findAll()).andReturn(games);

        gameService = new GameService(gameDao, ownsGameDao);

        EasyMock.replay(gameDao);

        int result = gameService.search("cool").size();
        assertEquals(2, result);
        result = gameService.getAll().size();
        assertEquals(3, result);

        EasyMock.verify(gameDao);
    }

    @Test
    public void testAddGame()
    {
        List<Game> games = List.of(new Game("Game 1"),new Game("Game 2"),new Game("Game 3"));
        Game addedGame = new Game("Very cool game");
        List<Game> finalList = List.of(games.get(0), games.get(1), games.get(2), addedGame);

        gameDao = EasyMock.mock(GameDao.class);
        EasyMock.expect(gameDao.findAll()).andReturn(games);
        EasyMock.expect(gameDao.save(addedGame)).andReturn(addedGame);
        EasyMock.expect(gameDao.findAll()).andReturn(finalList);

        gameService = new GameService(gameDao, ownsGameDao);

        EasyMock.replay(gameDao);

        int result = gameService.getAll().size();
        assertEquals(3, result);
        gameService.save(addedGame);
        result = gameService.getAll().size();
        assertEquals(4, result);

        EasyMock.verify(gameDao);
    }
}