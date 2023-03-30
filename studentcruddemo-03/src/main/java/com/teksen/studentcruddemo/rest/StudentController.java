package com.teksen.studentcruddemo.rest;

import com.teksen.studentcruddemo.entity.Student;
import com.teksen.studentcruddemo.service.StudentService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1")
public class StudentController {

    private final StudentService theStudentService;

    @PostConstruct
    public void loadStudentData(){
        theStudentService.save(createStudent("guduric@fb.com", "Marko", "Guduric"));
        theStudentService.save(createStudent("melih@fb.com", "Melih", "Mahmutoglu"));
        theStudentService.save(createStudent("nemenja@fb.com", "Nemenja", "Bjelica"));
    }

    private Student createStudent(String email, String firstname, String lastname){
        return Student.builder()
                .email(email)
                .firstname(firstname)
                .lastname(lastname)
                .build();
    }

    public StudentController(StudentService theStudentService) {
        this.theStudentService = theStudentService;
    }

    // Get all student
    @GetMapping(path = "/students")
    public List<Student> getStudents(){
        return theStudentService.findAll();
    }

    // Get Student by Id
    @GetMapping(path = "/students/{studentId}")
    public Student getStudent(@PathVariable Integer studentId){
        return theStudentService.findById(studentId);
    }

    // Add Student
    @PostMapping(path = "/students")
    public Student addStudent(@RequestBody Student theStudent){
        theStudent.setId(0);
        return theStudentService.save(theStudent);
    }

    // Update Student
    @PutMapping(path = "/students")
    public Student updateStudent(@RequestBody Student student){
        return theStudentService.save(student);
    }

    // Delete Student By Id
    @DeleteMapping(path = "/students/{studentId}")
    public String deleteStudent(@PathVariable Integer studentId){
        Student theStudent = theStudentService.findById(studentId);

        theStudentService.deleteById(studentId);
        return "Delete student with id - " + studentId;
    }

    // Search and Get Student By Firstname
    @GetMapping(path = "/students/search")
    public Student getStudentByFirstname(@RequestParam(value = "firstname", required = true) String firstname){
        return theStudentService.findByFirstname(firstname);
    }



}
