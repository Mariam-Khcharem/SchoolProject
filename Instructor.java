package edu.isgb.school.entities;

import jakarta.persistence.*;
import lombok.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.*;

    @Entity
    @Table(name = "t_instructor")
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public class Instructor {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String name;

        @ManyToOne
        @JoinColumn(name = "school_id")
        @JsonIgnore
        private School school;

        @OneToMany(mappedBy = "instructor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
        private List<Course> courses = new ArrayList<>();

        public void addCourse(Course c) {
            courses.add(c);
            c.setInstructor(this);
        }
    }
