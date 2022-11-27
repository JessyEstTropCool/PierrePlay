package be.helb.PierrePlay.daos;

import be.helb.PierrePlay.models.Platform;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlatformDao extends JpaRepository<Platform, Long> {
}
