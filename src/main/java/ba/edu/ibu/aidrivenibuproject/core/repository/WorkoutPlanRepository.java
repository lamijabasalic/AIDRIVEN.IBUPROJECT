package ba.edu.ibu.aidrivenibuproject.core.repository;

import ba.edu.ibu.aidrivenibuproject.core.model.WorkoutRoutine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkoutPlanRepository extends JpaRepository<WorkoutRoutine, Long> {
    List<WorkoutRoutine> findByUserId(Long userId);
}
