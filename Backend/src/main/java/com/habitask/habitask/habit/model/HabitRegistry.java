package com.habitask.habitask.habit.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    @EqualsAndHashCode(onlyExplicitlyIncluded = true)
    @Entity
    @Table(name = "habit_registry_tb")
    public class HabitRegistry {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @EqualsAndHashCode.Include
        private Long id;

        @OneToOne(mappedBy = "habitRegistry")
        private Habit habit;

        @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
        private Instant completedTime;


    }
