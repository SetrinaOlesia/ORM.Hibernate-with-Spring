package com.sprint.hibernate.service.serviceImpl;

import com.sprint.hibernate.entity.Sprint;
import com.sprint.hibernate.entity.Task;
import com.sprint.hibernate.repository.TaskRepository;
import com.sprint.hibernate.service.TaskService;
import java.util.Optional;

public class TaskServiceImpl implements TaskService {

    final private TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Task addTaskToSprint(Task task, Sprint sprint) {
        if (task.getId() != null) {
            taskRepository.getOne(sprint.getId());
        }
        taskRepository.save(task);
        task.setSprint(sprint);
        return task;
    }

    @Override
    public Task getTaskById(Long taskId) {
        Optional<Task> task = taskRepository.findById(taskId);
        return task.orElse(null);
    }
}
