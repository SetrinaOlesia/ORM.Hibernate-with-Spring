package com.sprint.hibernate.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
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
@Entity(name = "sprint")
public class Sprint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate finish;
    @Column(name = "start_date")
    private LocalDate startDate;
    private String title;

    @ManyToOne(fetch = FetchType.LAZY)
    private Marathon marathon;


}
