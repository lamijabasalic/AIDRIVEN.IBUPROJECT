package ba.edu.ibu.aidrivenibuproject.core.repository;

import ba.edu.ibu.aidrivenibuproject.core.model.HealthProgress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface HealthProgressRepository extends JpaRepository<HealthProgress, Long> {
    List<HealthProgress> findByUserId(Long userId);
    List<HealthProgress> findByUserIdAndProgressDateBetween(Long userId, Date startDate, Date endDate);
}
