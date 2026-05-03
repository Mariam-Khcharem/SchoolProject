package edu.isgb.school.entities;
import jakarta.persistence.*;
import lombok.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

    @Entity
    @Table(name = "t_course")
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public class Course {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String title;

        @ManyToOne
        @JoinColumn(name = "instructor_id")
        @JsonIgnore
        private Instructor instructor;
    }
