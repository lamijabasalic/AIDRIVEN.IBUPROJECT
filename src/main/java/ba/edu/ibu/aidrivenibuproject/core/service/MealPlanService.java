package ba.edu.ibu.aidrivenibuproject.core.service;

import ba.edu.ibu.aidrivenibuproject.core.model.MealPlan;
import ba.edu.ibu.aidrivenibuproject.core.repository.MealPlanRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MealPlanService {
    private final MealPlanRepository mealPlanRepository;

    public MealPlanService(MealPlanRepository mealPlanRepository) {
        this.mealPlanRepository = mealPlanRepository;
    }

    public MealPlan createMealPlan(MealPlan mealPlan) {
        return mealPlanRepository.save(mealPlan);
    }

    public List<MealPlan> getMealPlansByUserId(Long userId) {
        return mealPlanRepository.findByUserId(userId);
    }

    public void updateMealPlan(MealPlan mealPlan) {
        if (!mealPlanRepository.existsById(mealPlan.getId())) {
            throw new IllegalArgumentException("Meal plan not found!");
        }
        mealPlanRepository.save(mealPlan);
    }

    public void deleteMealPlan(Long mealPlanId) {
        mealPlanRepository.deleteById(mealPlanId);
    }
}
