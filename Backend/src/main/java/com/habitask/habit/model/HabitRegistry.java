package com.habitask.habit.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "habit_registry_tb")
public class HabitRegistry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "habitRegistry")
    private Habit habit;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant completedTime;


}
