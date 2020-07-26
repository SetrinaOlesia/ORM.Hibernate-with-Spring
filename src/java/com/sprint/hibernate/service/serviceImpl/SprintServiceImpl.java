package com.sprint.hibernate.service.serviceImpl;
import com.sprint.hibernate.entity.Marathon;
import com.sprint.hibernate.entity.Sprint;
import com.sprint.hibernate.repository.MarathonRepository;
import com.sprint.hibernate.repository.SprintRepository;
import com.sprint.hibernate.service.SprintService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SprintServiceImpl implements SprintService {
    final private SprintRepository sprintRepository;
    final private MarathonRepository marathonRepository;

    public SprintServiceImpl(SprintRepository sprintRepository, MarathonRepository marathonRepository) {
        this.sprintRepository = sprintRepository;
        this.marathonRepository = marathonRepository;
    }
    @Override
    public List<Sprint> getSprintByMarathonId(Long marathonId) {
        List<Sprint> sprints = sprintRepository.findByMarathon(marathonId);
        if (!sprints.isEmpty()) {
            return sprints;
        }
        return new ArrayList<>();
    }

    @Override
    public boolean addSprintToMarathon(Sprint sprint, Marathon marathon) {
        if (sprint.getId() != null) {
            sprintRepository.getOne(sprint.getId());
            return true;
        }
        sprint = sprintRepository.save(sprint);
        sprint.setMarathon(marathon);
        return false;
    }

    @Override
    public boolean updateSprint(Sprint sprint) {
        if (sprint.getId() != null) {
            Optional<Sprint> sprints = sprintRepository.findById(sprint.getId());
            if (sprints.isPresent()) {
                Sprint newSprint = sprints.get();
                newSprint.setTitle(sprint.getTitle());
                newSprint.setStartDate(sprint.getStartDate());
                newSprint.setFinish(sprint.getFinish());
                newSprint = sprintRepository.save(newSprint);
                return true;
            }
        }
        sprint = sprintRepository.save(sprint);
        return false;
    }

    @Override
    public Sprint getSprintById(Long sprintId) {
        Optional<Sprint> sprint = sprintRepository.findById(sprintId);
        return sprint.orElse(null);
    }
}
