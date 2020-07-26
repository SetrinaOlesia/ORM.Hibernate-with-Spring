package com.sprint.hibernate.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigInteger;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate created;
    private String title;
    private LocalDate update;
    @Column(name = "sprint_id")
    private BigInteger sprintId;

    @ManyToOne(fetch = FetchType.LAZY)
    private Sprint sprint;

}
