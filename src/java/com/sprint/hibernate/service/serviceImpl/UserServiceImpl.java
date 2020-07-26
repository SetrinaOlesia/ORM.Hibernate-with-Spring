package com.sprint.hibernate.service.serviceImpl;

import com.sprint.hibernate.entity.Marathon;
import com.sprint.hibernate.entity.Task;
import com.sprint.hibernate.entity.User;
import com.sprint.hibernate.repository.MarathonRepository;
import com.sprint.hibernate.repository.UserRepository;
import com.sprint.hibernate.service.UserService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;


@Service
@Transactional
public class UserServiceImpl implements UserService {

    final private UserRepository userRepository;
    final private MarathonRepository marathonRepository;

    public UserServiceImpl(UserRepository userRepository, MarathonRepository marathonRepository) {
        this.userRepository = userRepository;
        this.marathonRepository = marathonRepository;
    }

    @Override
    public List<User> getAll() {
        List<User> users = userRepository.findAll();
        if (!users.isEmpty()) {
            return users;
        }
        return new ArrayList<>();
    }

    @Override
    public User getUserById(Long userId) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()) {
            return user.get();
        } else {
            throw new EntityNotFoundException(" No user, exist for given id");
        }
    }

    @Override
    public User createOrUpdateUser(User entity) {
        if (entity.getId() != null) {
            Optional<User> user = userRepository.findById(entity.getId());
            if (user.isPresent()) {
                User newUser = user.get();
                newUser.setEmail(entity.getEmail());
                newUser.setFirstName(entity.getFirstName());
                newUser.setLastName(entity.getLastName());
                newUser.setRole(entity.getRole());
                newUser.setPassword(entity.getPassword());
                newUser = userRepository.save(newUser);
                return newUser;
            }
        }
        entity = userRepository.save(entity);
        return entity;
    }

    @Override
    public List<User> getAllByRole(String role) {
        return userRepository.getAllRole(User.Role.valueOf(role.toUpperCase()));
    }

    @Override
    public boolean addUserToMarathon(User user, Marathon marathon) {

        Marathon marathonFromDb = marathonRepository.getOne(marathon.getId());
        if ((!marathonFromDb.getUser().contains(user))) {
            marathonFromDb.getUser().add(user);
            marathonRepository.save(marathonFromDb);
            return true;
        }
        return false;
    }

}
