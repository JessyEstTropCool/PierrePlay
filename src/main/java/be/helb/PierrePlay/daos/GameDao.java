package be.helb.PierrePlay.daos;

import be.helb.PierrePlay.models.Game;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GameDao extends JpaRepository<Game, Long>
{
    List<Game> findByTitle(String title);
    List<Game> findByPegi(int pegi);
    List<Game> findByEsrb(String esrb);
    List<Game> findByCero(String cero);
}
