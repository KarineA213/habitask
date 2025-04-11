package com.habitask.habitask.reminder.model;

import com.habitask.habitask.task.model.Task;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    @EqualsAndHashCode(onlyExplicitlyIncluded = true)
    @Entity
    @Table(name = "reminder_tb")
    public class Reminder {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @EqualsAndHashCode.Include
        private Long id;

        @ManyToOne(fetch = FetchType.LAZY) //cascade merge não é muito para many to one, por isso não coloquei
        @JoinColumn(name = "task_id")
        private Task task;

        @Enumerated(EnumType.STRING)
        private ReminderList reminder;

        @Enumerated(EnumType.STRING)
        private OffsetList offsetUnit;

        private Boolean enabled;
        private int offsetValue;
        private String message;
}
