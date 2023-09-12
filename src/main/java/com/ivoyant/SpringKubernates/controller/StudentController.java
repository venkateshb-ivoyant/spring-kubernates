package com.ivoyant.SpringKubernates.controller;

import com.ivoyant.SpringKubernates.entity.Student;
import com.ivoyant.SpringKubernates.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private final StudentRepository repository;
    private static final Logger LOGGER = LoggerFactory.getLogger(StudentController.class);


    public StudentController(StudentRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/getAll")
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
        if (repository.existsById(Long.valueOf(id))) {
            repository.deleteById(Long.valueOf(id));
            return new ResponseEntity<>("Student deleted", HttpStatus.OK);
        } else {
            LOGGER.info("Student Does not  Exist for the id: {}", id);
            return new ResponseEntity<>("Student Does not Exist", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<String> deleteAllStudent() {
        repository.deleteAll();
        return new ResponseEntity<>("All Students Deleted Successfully", HttpStatus.OK);
    }

    @PutMapping("updateStudent/{id}")
    public ResponseEntity<String> updateStudent(@PathVariable Long id, @RequestBody Student student) {
        Student student1 = repository.findById(id).get();
        student1.setCourse(student.getCourse());
        student1.setName(student.getName());
        student1.setRegNo(student.getRegNo());
        repository.save(student1);
        return new ResponseEntity<>("Student Updated Successfully", HttpStatus.OK);
    }
}
