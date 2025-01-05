package ba.edu.ibu.aidrivenibuproject.core.repository;

import ba.edu.ibu.aidrivenibuproject.core.model.MealPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MealPlanRepository extends JpaRepository<MealPlan, Long> {
    List<MealPlan> findByUserId(Long userId);
}
