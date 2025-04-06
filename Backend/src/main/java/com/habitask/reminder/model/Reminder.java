package com.habitask.reminder.model;


import com.habitask.task.model.Task;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "reminder_tb")
public class Reminder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "task_id")
    private Task task;

    @Enumerated(EnumType.STRING)
    private ReminderList reminder;

    @Enumerated(EnumType.STRING)
    private OffsetList offsetUnit;

//    @Enumerated(EnumType.STRING)
//    @JoinColumn(name = "")
//    private PriorityList priority;

    private boolean enabled;
    private int offsetValue;
    private String message;
}
