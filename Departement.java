package edu.isgb.school.entities;
import jakarta.persistence.*;
import lombok.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

    @Entity
    @Table(name = "t_departement")
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public class Departement {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "pk_departement")
        private Long id;

        @Column(name = "cl_name", nullable = false)
        private String name;

        @ManyToOne
        @JoinColumn(name = "school_PK_school")   // custom foreign key name
        @JsonIgnore
        private School school;
    }
