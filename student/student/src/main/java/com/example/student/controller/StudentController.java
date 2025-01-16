package com.example.student.controller;

import com.example.student.dto.StudentResponse;
import com.example.student.entity.StudentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.student.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService service;

    @GetMapping
    public List<StudentEntity> getAll() {
        return service.findAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<StudentResponse> getById(@PathVariable String id) {
        StudentResponse student = service.findById(id);
        return student != null ? ResponseEntity.ok(student) : ResponseEntity.notFound().build();
    }
    @PostMapping
    public StudentEntity create(@RequestBody StudentEntity student) {
        return service.save(student);
    }
    @PutMapping("/{id}")
    public ResponseEntity<StudentEntity> update(@PathVariable String id, @RequestBody StudentEntity student) {
        if (service.findById(id) == null) {
            return ResponseEntity.notFound().build();
        }
        student.setId(id);
        return ResponseEntity.ok(service.save(student));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        if (service.findById(id) == null) {
            return ResponseEntity.notFound().build();
        }
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
