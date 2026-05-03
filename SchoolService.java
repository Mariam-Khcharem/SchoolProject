package edu.isgb.school.service;

import edu.isgb.school.entities.*;
import edu.isgb.school.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class SchoolService {

    @Autowired private SchoolRepository schoolRepo;
    @Autowired private StudentRepository studentRepo;
    @Autowired private InstructorRepository instructorRepo;
    @Autowired private DepartementRepository deptRepo;
    @Autowired private CourseRepository courseRepo;
    @Autowired private AdressRepository addressRepo;

    @Transactional
    public School createSchoolWithDetails(School school) {
        for (Student s : school.getStudents()) s.setSchool(school);
        for (Instructor i : school.getInstructors()) i.setSchool(school);
        for (Departement d : school.getDepartments()) d.setSchool(school);
        return schoolRepo.save(school);
    }

    public School getSchoolById(Long id) {
        return schoolRepo.findById(id).orElseThrow(() -> new RuntimeException("School not found"));
    }

    @Transactional
    public Student createStudentWithAddressAndSchool(Student student, Long schoolId) {
        School school = getSchoolById(schoolId);
        student.setSchool(school);
        if (student.getAddress() != null) {
            addressRepo.save(student.getAddress());
        }
        return studentRepo.save(student);
    }

    public List<Student> listAllStudents() {
        return studentRepo.findAll();
    }

    @Transactional
    public Instructor createInstructorWithCourses(Instructor instructor) {
        for (Course c : instructor.getCourses()) {
            c.setInstructor(instructor);
        }
        return instructorRepo.save(instructor);
    }

    public List<Instructor> listInstructorsByName(String name) {
        return instructorRepo.findByNameContaining(name);
    }

    public Instructor getInstructorById(Long id) {
        return instructorRepo.findById(id).orElseThrow(() -> new RuntimeException("Instructor not found"));
    }

    public Course getCourseById(Long id) {
        return courseRepo.findById(id).orElseThrow(() -> new RuntimeException("Course not found"));
    }

    public List<Course> getCoursesByInstructorId(Long instructorId) {
        Instructor instructor = getInstructorById(instructorId);
        return instructor.getCourses();
    }

    @Transactional
    public Course addCourseToInstructor(Long instructorId, Course course) {
        Instructor instructor = getInstructorById(instructorId);
        course.setInstructor(instructor);
        return courseRepo.save(course);
    }
}