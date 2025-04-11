package com.habitask.habitask.user.model;

import com.habitask.habitask.habit.model.Habit;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    @EqualsAndHashCode(onlyExplicitlyIncluded = true)
    @Entity
    @Table(name = "user_tb")
    public class User {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @EqualsAndHashCode.Include
        private Long id;

        @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
        private List<Habit> habits;

        @Email
        @NotBlank
        @Size(min = 8)
        private String email;

        @NotBlank (message = "Digite sua senha")
        @Size(min = 6, max = 20, message = "senha deve ter entre 6 e 20 caracteres")
        @Pattern(
                regexp = ""
        )
        private String password;

        @NotNull
        private LocalDate birthday;

    }
