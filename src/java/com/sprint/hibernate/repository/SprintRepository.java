package com.sprint.hibernate.repository;

import com.sprint.hibernate.entity.Sprint;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SprintRepository extends JpaRepository <Sprint, Long> {
    List<Sprint> findByMarathon(Long id);
}
