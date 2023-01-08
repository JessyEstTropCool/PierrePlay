package be.helb.PierrePlay.daos;

import be.helb.PierrePlay.models.OwnsGame;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnsGameDao extends JpaRepository<OwnsGame, Long>  {
}
