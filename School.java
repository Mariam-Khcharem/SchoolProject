package edu.isgb.school.entities;
import jakarta.persistence.*;
import lombok.*;
import java.util.*;

    @Entity
    @Table(name = "t_school")   // table name differs from class name
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public class School {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "PK_school")   // column name differs from field "id"
        private Long id;

        @Column(name = "cl_name_school", nullable = false)
        private String name;

        private String phone;   // column name = "phone" – matches default

        // Bidirectional with Department
        @OneToMany(mappedBy = "school", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
        private List<Departement> departments = new ArrayList<>();

        // Bidirectional with Instructor
        @OneToMany(mappedBy = "school", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
        private List<Instructor> instructors = new ArrayList<>();

        // Bidirectional with Student
        @OneToMany(mappedBy = "school", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
        private List<Student> students = new ArrayList<>();

        public void addDepartment(Departement d) {
            departments.add(d);
            d.setSchool(this);
        }
        public void addInstructor(Instructor i) {
            instructors.add(i);
            i.setSchool(this);
        }
        public void addStudent(Student s) {
            students.add(s);
            s.setSchool(this);
        }
    }
