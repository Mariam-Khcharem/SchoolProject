package edu.isgb.school.test;

import edu.isgb.school.entities.*;
import edu.isgb.school.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/test/school")
public class TestSchoolController {

    @Autowired
    private SchoolService schoolService;

    @PostMapping("/full")
    public ResponseEntity<School> createFullSchool(@RequestBody School school) {
        return ResponseEntity.ok(schoolService.createSchoolWithDetails(school));
    }

    @GetMapping("/{id}")
    public ResponseEntity<School> getSchoolById(@PathVariable Long id) {
        return ResponseEntity.ok(schoolService.getSchoolById(id));
    }

    @PostMapping("/student")
    public ResponseEntity<Student> createStudent(@RequestBody Student student, @RequestParam Long schoolId) {
        return ResponseEntity.ok(schoolService.createStudentWithAddressAndSchool(student, schoolId));
    }

    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return schoolService.listAllStudents();
    }

    @PostMapping("/instructor")
    public ResponseEntity<Instructor> createInstructor(@RequestBody Instructor instructor) {
        return ResponseEntity.ok(schoolService.createInstructorWithCourses(instructor));
    }

    @GetMapping("/instructors/search")
    public List<Instructor> searchInstructors(@RequestParam String name) {
        return schoolService.listInstructorsByName(name);
    }

    @GetMapping("/instructor/{id}")
    public Instructor getInstructor(@PathVariable Long id) {
        return schoolService.getInstructorById(id);
    }

    @GetMapping("/course/{id}")
    public Course getCourse(@PathVariable Long id) {
        return schoolService.getCourseById(id);
    }

    @GetMapping("/instructor/{id}/courses")
    public List<Course> getCoursesForInstructor(@PathVariable Long id) {
        return schoolService.getCoursesByInstructorId(id);
    }

    @PostMapping("/instructor/{id}/addCourse")
    public Course addCourseToInstructor(@PathVariable Long id, @RequestBody Course course) {
        return schoolService.addCourseToInstructor(id, course);
    }
}