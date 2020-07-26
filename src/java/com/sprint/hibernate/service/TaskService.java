package com.sprint.hibernate.service;

import com.sprint.hibernate.entity.Sprint;
import com.sprint.hibernate.entity.Task;

public interface TaskService {
    public Task addTaskToSprint(Task task, Sprint sprint);

    public Task getTaskById(Long taskId);
}
