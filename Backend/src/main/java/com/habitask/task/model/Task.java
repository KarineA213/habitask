package com.habitask.task.model;

import com.habitask.common.enums.model.PriorityList;
import com.habitask.common.enums.model.ScheduleList;
import com.habitask.common.enums.model.StatusList;
import com.habitask.habit.model.Habit;
import com.habitask.reminder.model.Reminder;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "task_tb")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "habit_id")
    private Habit habit;

    @OneToMany(mappedBy = "task", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Reminder> reminders = new ArrayList<>();

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
    private boolean hasReminder;

}
