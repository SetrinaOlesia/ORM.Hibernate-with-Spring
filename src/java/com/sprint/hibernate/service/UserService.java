package com.sprint.hibernate.service;

import com.sprint.hibernate.entity.Marathon;
import com.sprint.hibernate.entity.Task;
import com.sprint.hibernate.entity.User;
import java.util.List;

public interface UserService {
    public List<User> getAll();

    public User getUserById(Long userId);

    public User createOrUpdateUser(User user);

    public List<User> getAllByRole(String  role);

    public boolean addUserToMarathon(User user, Marathon marathon);


}

