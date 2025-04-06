package com.habitask.habit.model;

import com.habitask.task.model.Task;
import com.habitask.user.model.User;
import jakarta.persistence.*;
import lombok.*;

import java.rmi.registry.Registry;
import java.time.Instant;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "habit_tb")
public class Habit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany
    @JoinColumn(name = "task_id")
    private Set<Task> tasks;

    @OneToOne
    @JoinColumn(name = "registry_id")
    private HabitRegistry habitRegistry;

    @Enumerated(EnumType.STRING)
    private FrequencyList frequencyList;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant startTime;

    private String description;
    private boolean isActive;
    private int frequencyValue;


}
