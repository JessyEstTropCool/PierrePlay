package be.helb.PierrePlay.daos;

import be.helb.PierrePlay.models.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyDao  extends JpaRepository<Company, Long> {
}
