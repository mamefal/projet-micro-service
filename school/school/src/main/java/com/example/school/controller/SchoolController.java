package com.example.school.controller;

import com.example.school.service.SchoolService;
import com.example.school.entity.School;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/school")
public class SchoolController {
    @Autowired
    private SchoolService service;

    @GetMapping
    public List<School> getAll() { return service.findAll(); }
    @GetMapping("/{id}")
    public ResponseEntity<School> getById(@PathVariable Long id) {
        School school = service.findById(id);
        return school != null ? ResponseEntity.ok(school) : ResponseEntity.notFound().build();
    }
    @PostMapping
    public School create(@RequestBody School school) { return service.save(school); }
    @PutMapping("/{id}")
    public ResponseEntity<School> update(@PathVariable Long id, @RequestBody School school) {
        if (service.findById(id) == null) return ResponseEntity.notFound().build();
        school.setId(id);
        return ResponseEntity.ok(service.save(school));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
