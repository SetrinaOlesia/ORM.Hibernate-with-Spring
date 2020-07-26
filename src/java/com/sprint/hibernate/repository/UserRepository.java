package com.sprint.hibernate.repository;
import com.sprint.hibernate.entity.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> getAllRole(User.Role role);
}
