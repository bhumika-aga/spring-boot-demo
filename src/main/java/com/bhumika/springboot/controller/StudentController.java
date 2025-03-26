package com.bhumika.springboot.controller;

import com.bhumika.springboot.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {
    
    @GetMapping("/student")
    public Student getStudent() {
        return new Student(1, "Bhumika", "Agarwal");
    }
    
    @GetMapping("/allStudents")
    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Bhumika", "Agarwal"));
        students.add(new Student(2, "Shivam", "Bandral"));
        students.add(new Student(3, "Rishit", "Gupta"));
        students.add(new Student(4, "Aman", "Singh"));
        
        return students;
    }
    
    @GetMapping("/student/{id}")
    public Student getStudentById(@PathVariable("id") Integer id) {
        return new Student(id, "Bhumika", "Agarwal");
    }
    
    @GetMapping("/student/query")
    public Student getStudentByIdParam(@RequestParam Integer id) {
        return new Student(id, "Bhumika", "Agarwal");
    }
    
    @PostMapping("/student")
    @ResponseStatus(HttpStatus.CREATED)
    public Student createStudent(@RequestBody Student student) {
        return student;
    }
    
    @PutMapping("/student/{id}/update")
    public Student updateStudent(@RequestBody Student student, @PathVariable("id") Integer id) {
        return student;
    }
    
    @DeleteMapping("/student/{id}/delete")
    public String deleteStudent(@PathVariable("id") Integer id) {
        return "Student with id " + id + " deleted successfully";
    }
}
