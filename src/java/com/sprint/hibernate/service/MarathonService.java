package com.sprint.hibernate.service;

import com.sprint.hibernate.entity.Marathon;
import java.util.List;

public interface MarathonService {
    public List<Marathon> getAll();

    public Marathon getMarathonById(Long marathonId);

    public Marathon createOrUpdate(Marathon marathon);

    public void deleteMarathonById(Long marathonId);
}
