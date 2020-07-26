package com.sprint.hibernate.service;

import com.sprint.hibernate.entity.Marathon;
import com.sprint.hibernate.entity.Sprint;
import java.util.List;

public interface SprintService {
    public List<Sprint> getSprintByMarathonId(Long marathonId);

    public boolean addSprintToMarathon(Sprint sprint, Marathon marathon);

    public boolean updateSprint(Sprint sprint);

    public Sprint getSprintById(Long sprintId);
}
