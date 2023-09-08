package com.ivoyant.SpringKubernates.controller;

import com.ivoyant.SpringKubernates.entity.Student;
import com.ivoyant.SpringKubernates.repository.StudentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // marks the class as a controller
@RequestMapping("/api/students") // Root path to the API endpoints in this class
public class StudentController {
    private final StudentRepository repository;

    public StudentController(StudentRepository repository) {
        this.repository = repository;
    }

    @GetMapping ("/getAll")
    public ResponseEntity<List<Student>> getAll() {
        return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/getStudent/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable String id) {
        return new ResponseEntity<>(repository.findById(Long.valueOf(id))
                .orElseThrow(() -> new IllegalStateException("Student with id " + id + " not found")), HttpStatus.OK);
    }

    @PostMapping("/createStudent")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        return new ResponseEntity<>(repository.save(student), HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteStudent/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable String id) {
        repository.deleteById(Long.valueOf(id));
        return new ResponseEntity<>("Student deleted", HttpStatus.OK);
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<String> deleteAllStudent() {
        repository.deleteAll();
        return new ResponseEntity<>("All Students Deleted Successfully", HttpStatus.OK);
    }
}
