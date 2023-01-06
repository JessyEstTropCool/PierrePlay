package be.helb.PierrePlay.daos;

import be.helb.PierrePlay.models.Game;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.sql.DataSource;
import java.util.List;

public interface GameDao extends JpaRepository<Game, Long>
{
    List<Game> findByTitle(String title);
    List<Game> findByPegi(int pegi);
}
