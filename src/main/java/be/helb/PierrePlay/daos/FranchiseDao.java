package be.helb.PierrePlay.daos;

import be.helb.PierrePlay.models.Franchise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FranchiseDao  extends JpaRepository<Franchise, Long> {
}
