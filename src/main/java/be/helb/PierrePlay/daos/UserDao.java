package be.helb.PierrePlay.daos;

import be.helb.PierrePlay.models.Game;
import be.helb.PierrePlay.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserDao  extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
