package be.helb.PierrePlay.daos;

import be.helb.PierrePlay.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao  extends JpaRepository<User, Long> {
}
