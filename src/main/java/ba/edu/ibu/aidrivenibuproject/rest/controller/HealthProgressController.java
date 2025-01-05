package ba.edu.ibu.aidrivenibuproject.rest.controller;

import ba.edu.ibu.aidrivenibuproject.core.model.HealthProgress;
import ba.edu.ibu.aidrivenibuproject.core.service.HealthProgressService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/healthprogress")
public class HealthProgressController {
    private final HealthProgressService healthProgressService;

    public HealthProgressController(HealthProgressService healthProgressService) {
        this.healthProgressService = healthProgressService;
    }

    @PostMapping
    public ResponseEntity<Object> logProgress(@RequestBody HealthProgress healthProgress) {
        HealthProgress loggedProgress = healthProgressService.logProgress(healthProgress);
        return ResponseEntity.ok(loggedProgress);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<Object> getProgressByUserId(@PathVariable Long userId) {
        List<HealthProgress> progressList = healthProgressService.getProgressByUserId(userId);
        return ResponseEntity.ok(progressList);
    }

    @GetMapping("/user/{userId}/date")
    public ResponseEntity<Object> getProgressByDateRange(
            @PathVariable Long userId,
            @RequestParam Date startDate,
            @RequestParam Date endDate) {
        List<HealthProgress> progressList = healthProgressService.getProgressByDateRange(userId, startDate, endDate);
        return ResponseEntity.ok(progressList);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteProgress(@PathVariable Long id) {
        healthProgressService.deleteProgress(id);
        return ResponseEntity.noContent().build();
    }
}
