package ba.edu.ibu.aidrivenibuproject.core.service;

import ba.edu.ibu.aidrivenibuproject.core.model.HealthProgress;
import ba.edu.ibu.aidrivenibuproject.core.repository.HealthProgressRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class HealthProgressService {
    private final HealthProgressRepository healthProgressRepository;

    public HealthProgressService(HealthProgressRepository healthProgressRepository) {
        this.healthProgressRepository = healthProgressRepository;
    }

    public HealthProgress logProgress(HealthProgress healthProgress) {
        return healthProgressRepository.save(healthProgress);
    }

    public List<HealthProgress> getProgressByUserId(Long userId) {
        return healthProgressRepository.findByUserId(userId);
    }

    public List<HealthProgress> getProgressByDateRange(Long userId, Date startDate, Date endDate) {
        return healthProgressRepository.findByUserIdAndProgressDateBetween(userId, startDate, endDate);
    }

    public void deleteProgress(Long progressId) {
        healthProgressRepository.deleteById(progressId);
    }
}
