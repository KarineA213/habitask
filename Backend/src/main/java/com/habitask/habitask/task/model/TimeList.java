package com.habitask.habitask.task.model;

import com.habitask.habitask.common.enums.StatusList;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;


    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    @EqualsAndHashCode(onlyExplicitlyIncluded = true)
    @Entity
    @Table(name = "time_list_tb")
    public class TimeList {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @EqualsAndHashCode.Include
        private Long id;

        @OneToOne
        //Many to one se tiver varias timelist
        private Task task;

        @Enumerated(EnumType.STRING)
        private StatusList status;

        @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
        private LocalDateTime taskTime;

    }
