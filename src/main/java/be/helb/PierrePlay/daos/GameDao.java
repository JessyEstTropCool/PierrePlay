package be.helb.PierrePlay.daos;

import be.helb.PierrePlay.models.Game;
import be.helb.PierrePlay.models.OwnsGame;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface GameDao extends JpaRepository<Game, Long>
{
    List<Game> findByTitleContainsIgnoreCase(String title);
    List<Game> findByPegi(int pegi);
    List<Game> findByGameIdIn(Collection<Long> ids);
}
