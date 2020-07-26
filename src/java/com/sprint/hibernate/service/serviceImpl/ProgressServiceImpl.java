package com.sprint.hibernate.service.serviceImpl;

import com.sprint.hibernate.entity.Progress;
import com.sprint.hibernate.entity.Task;
import com.sprint.hibernate.entity.User;
import com.sprint.hibernate.repository.ProgressRepository;
import com.sprint.hibernate.service.ProgressService;
import java.util.List;
import java.util.Optional;

public class ProgressServiceImpl implements ProgressService {

    final private ProgressRepository progressRepository;

    public ProgressServiceImpl(ProgressRepository progressRepository) {
        this.progressRepository = progressRepository;
    }

    @Override
    public Progress getProgressBuId(Long usersId) {
        Optional<Progress> sprint = progressRepository.findById(usersId);
        return sprint.orElse(null);
    }

    @Override
    public Progress addTaskForStudent(Task task, User user) {
        return null;
    }

    @Override
    public Progress addOrUpdateProgress(Progress p) {
        if (p.getId() != null) {
            Optional<Progress> progress = progressRepository.findById(p.getId());
            if (progress.isPresent()) {
                Progress newProgress = progress.get();
                newProgress.setStarted(p.getStarted());
                newProgress.setUpdate(p.getUpdate());
                newProgress.setStatus(p.getStatus());
                newProgress = progressRepository.save(newProgress);
                return newProgress;
            }
        }

        return progressRepository.save(p);
    }


    @Override
    public List<Progress> allProgressByUserIdAndMarathonId(Long marathonId, Long usersId) {
        return null;
    }

    @Override
    public List<Progress> allProgressByUserIdAndSprintId(Long sprintId, Long usersId) {
        return null;
    }
}
