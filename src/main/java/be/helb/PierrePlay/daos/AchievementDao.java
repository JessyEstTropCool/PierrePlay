package be.helb.PierrePlay.daos;

import be.helb.PierrePlay.models.Achievement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AchievementDao  extends JpaRepository<Achievement, Long> {
}
