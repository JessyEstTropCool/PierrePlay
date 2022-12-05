package be.helb.PierrePlay.services;

import be.helb.PierrePlay.daos.GameDao;
import be.helb.PierrePlay.models.Game;
import org.easymock.EasyMock;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameServiceTest
{
    private GameDao gameDao;

    private GameService gameService;

    @Test
    public void testGetAllGames()
    {
        List<Game> games = List.of(new Game("Supah Maro"),new Game("Sonk da hedg"),new Game("Kirbo goes"));

        gameDao = EasyMock.mock(GameDao.class);
        EasyMock.expect(gameDao.findAll()).andReturn(games);
        gameService = new GameService(gameDao);
        EasyMock.replay(gameDao);
        int result = gameService.getAll().size();
        EasyMock.verify(gameDao);
        assertEquals(3, result);
        //gameDao.findAll();
    }
}