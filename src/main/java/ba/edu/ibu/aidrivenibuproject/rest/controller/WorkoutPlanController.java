package ba.edu.ibu.aidrivenibuproject.rest.controller;

import ba.edu.ibu.aidrivenibuproject.core.model.WorkoutRoutine;
import ba.edu.ibu.aidrivenibuproject.core.service.WorkoutPlanService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/workoutplans")
public class WorkoutPlanController {
    private final WorkoutPlanService workoutPlanService;

    public WorkoutPlanController(WorkoutPlanService workoutPlanService) {
        this.workoutPlanService = workoutPlanService;
    }

    @PostMapping
    public ResponseEntity<Object> createWorkoutPlan(@RequestBody WorkoutRoutine workoutRoutine) {
        WorkoutRoutine createdRoutine = workoutPlanService.createWorkoutRoutine(workoutRoutine);
        return ResponseEntity.ok(createdRoutine);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<Object> getWorkoutPlansByUserId(@PathVariable Long userId) {
        List<WorkoutRoutine> routines = workoutPlanService.getWorkoutRoutinesByUserId(userId);
        return ResponseEntity.ok(routines);
    }

    @PutMapping
    public ResponseEntity<Object> updateWorkoutPlan(@RequestBody WorkoutRoutine workoutRoutine) {
        try {
            workoutPlanService.updateWorkoutRoutine(workoutRoutine);
            return ResponseEntity.ok().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteWorkoutPlan(@PathVariable Long id) {
        workoutPlanService.deleteWorkoutRoutine(id);
        return ResponseEntity.noContent().build();
    }
}
