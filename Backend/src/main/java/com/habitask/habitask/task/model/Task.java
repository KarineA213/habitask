package com.habitask.habitask.task.model;

import com.habitask.habitask.common.enums.PriorityList;
import com.habitask.habitask.common.enums.ScheduleList;
import com.habitask.habitask.common.enums.StatusList;
import com.habitask.habitask.habit.model.Habit;
import com.habitask.habitask.reminder.model.Reminder;
import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    @EqualsAndHashCode(onlyExplicitlyIncluded = true)
    @Entity
    @Table(name = "task_tb")
    public class Task {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @EqualsAndHashCode.Include
        private Long id;

        @ManyToOne
        @JoinColumn(name = "habit_id")
        private Habit habit;

        @OneToMany(mappedBy = "task", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
        private List<Reminder> reminders = new ArrayList<>();

        //aqui eu n entendi se tem várias timelist ou é um pra um, eu coloquei um pra um agr mas poderia ser
        //@OnetoMany pq qtalvez teriam varias.
        @OneToOne(mappedBy = "task", cascade = CascadeType.ALL)
        private TimeList timelist;

        @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
        private Instant deadline;

        @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
        private Instant scheduleTime;

        @Enumerated(EnumType.STRING)
        private StatusList status;

        @Enumerated(EnumType.STRING)
        private PriorityList priority;

        @Enumerated(EnumType.STRING)
        private ScheduleList schedule;

        private String description;
        private int scheduleValue;
        private Boolean hasReminder;

    }

