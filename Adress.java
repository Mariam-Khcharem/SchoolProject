package edu.isgb.school.entities;

import jakarta.persistence.*;
import lombok.*;

    @Entity
    @Table(name = "t_adress")
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public class Adress {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;        // column "id" – matches default

        private String street;
        private String city;
        private String zipCode;
    }
