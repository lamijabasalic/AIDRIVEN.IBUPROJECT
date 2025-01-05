package ba.edu.ibu.aidrivenibuproject.core.service;

import ba.edu.ibu.aidrivenibuproject.core.model.WorkoutRoutine;
import ba.edu.ibu.aidrivenibuproject.core.repository.WorkoutPlanRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkoutPlanService {
    private final WorkoutPlanRepository workoutPlanRepository;

    public WorkoutPlanService(WorkoutPlanRepository workoutPlanRepository) {
        this.workoutPlanRepository = workoutPlanRepository;
    }

    public WorkoutRoutine createWorkoutRoutine(WorkoutRoutine workoutRoutine) {
        return workoutPlanRepository.save(workoutRoutine);
    }

    public List<WorkoutRoutine> getWorkoutRoutinesByUserId(Long userId) {
        return workoutPlanRepository.findByUserId(userId);
    }

    public void updateWorkoutRoutine(WorkoutRoutine workoutRoutine) {
        if (!workoutPlanRepository.existsById(workoutRoutine.getId())) {
            throw new IllegalArgumentException("Workout routine not found!");
        }
        workoutPlanRepository.save(workoutRoutine);
    }

    public void deleteWorkoutRoutine(Long workoutRoutineId) {
        workoutPlanRepository.deleteById(workoutRoutineId);
    }
}
