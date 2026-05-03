package edu.isgb.school.entities;
import jakarta.persistence.*;
import lombok.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

    @Entity
    @Table(name = "t_student")
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public class Student {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;        // default column "id"

        private String firstName;
        private String lastName;

        // Bidirectional with School
        @ManyToOne
        @JoinColumn(name = "school_id")   // default would be "school_id" anyway – optional, but kept for clarity
        @JsonIgnore
        private School school;

        // Unidirectional to Address (no backref)
        @OneToOne(cascade = CascadeType.ALL)
        @JoinColumn(name = "adress_id")  // default would be "address_id" – optional
        private Adress address;
    }
