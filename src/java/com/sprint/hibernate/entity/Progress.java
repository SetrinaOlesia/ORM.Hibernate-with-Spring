package com.sprint.hibernate.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="progress")
public class Progress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "DATE")
    private LocalDate started;

    @Column(columnDefinition = "DATE")
    private LocalDate update;

    @ManyToOne
    private User trainee;

    @OneToOne
    private Task task;


    @Enumerated(EnumType.STRING)
    private TaskStatus status;


    public enum TaskStatus {
        PASS, FAIL, PENDING
    }
}
