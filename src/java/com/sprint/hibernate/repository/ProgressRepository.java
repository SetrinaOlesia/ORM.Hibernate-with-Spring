package com.sprint.hibernate.repository;

import com.sprint.hibernate.entity.Progress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProgressRepository extends JpaRepository<Progress, Long> {



}