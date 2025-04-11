package com.habitask.habitask.habit.model;

import com.habitask.habitask.task.model.Task;
import com.habitask.habitask.user.model.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.Set;

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    @EqualsAndHashCode(onlyExplicitlyIncluded = true)
    @Entity
    @Table(name = "habit_tb")
    public class Habit {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @EqualsAndHashCode.Include
        private Long id;

        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "user_id")
        private User user;

        @OneToMany(mappedBy = "habit", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
        private Set<Task> tasks;

        @OneToOne
        @JoinColumn(name = "registry_id")
        private HabitRegistry habitRegistry;

        @Enumerated(EnumType.STRING)
        private FrequencyList frequencyList;

        @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
        private Instant startTime;


        private String description;
        private Boolean isActive;
        private int frequencyValue;

    }
