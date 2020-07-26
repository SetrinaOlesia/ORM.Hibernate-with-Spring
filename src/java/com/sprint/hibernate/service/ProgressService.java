package com.sprint.hibernate.service;

import com.sprint.hibernate.entity.Progress;
import com.sprint.hibernate.entity.Task;
import com.sprint.hibernate.entity.User;
import java.util.List;

import org.hibernate.annotations.Table;


public interface ProgressService {
    public Progress getProgressBuId(Long usersId);

    public Progress addTaskForStudent(Task task, User user);

    public Progress addOrUpdateProgress(Progress progress);

//    public boolean setStatus(Task.TaskStatus taskStatus, Progress progress);

    public List<Progress> allProgressByUserIdAndMarathonId(Long marathonId, Long usersId);

    public List<Progress> allProgressByUserIdAndSprintId(Long sprintId, Long usersId);
}
