package be.helb.PierrePlay.daos;

import be.helb.PierrePlay.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewDao extends JpaRepository<Review, Long> {
}
