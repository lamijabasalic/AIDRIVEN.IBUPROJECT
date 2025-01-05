package ba.edu.ibu.aidrivenibuproject.rest.controller;

import ba.edu.ibu.aidrivenibuproject.core.model.MealPlan;
import ba.edu.ibu.aidrivenibuproject.core.service.MealPlanService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mealplans")
public class MealPlanController {
    private final MealPlanService mealPlanService;

    public MealPlanController(MealPlanService mealPlanService) {
        this.mealPlanService = mealPlanService;
    }

    @PostMapping
    public ResponseEntity<Object> createMealPlan(@RequestBody MealPlan mealPlan) {
        MealPlan createdMealPlan = mealPlanService.createMealPlan(mealPlan);
        return ResponseEntity.ok(createdMealPlan);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<Object> getMealPlansByUserId(@PathVariable Long userId) {
        List<MealPlan> mealPlans = mealPlanService.getMealPlansByUserId(userId);
        return ResponseEntity.ok(mealPlans);
    }

    @PutMapping
    public ResponseEntity<Object> updateMealPlan(@RequestBody MealPlan mealPlan) {
        try {
            mealPlanService.updateMealPlan(mealPlan);
            return ResponseEntity.ok().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteMealPlan(@PathVariable Long id) {
        mealPlanService.deleteMealPlan(id);
        return ResponseEntity.noContent().build();
    }
}
