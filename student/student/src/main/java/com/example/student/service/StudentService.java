package com.example.student.service;

import com.example.student.dto.SchoolResponse;
import com.example.student.dto.StudentResponse;
import com.example.student.entity.StudentEntity;
import com.example.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repository;

    @Autowired
    private RestTemplate restTemplate;
    public List<StudentEntity> findAll() {
        return repository.findAll();
    }
    public StudentResponse findById(String id) {
        StudentEntity student = repository.findById(id).orElse(null);
        if (student != null) {
            SchoolResponse schoolResponse = restTemplate.getForEntity(
                    "http://localhost:8080/school/" + student.getSchoolId(),
                    SchoolResponse.class
            ).getBody();
            return new StudentResponse(student.getName(), student.getName(), student.getGenre(), schoolResponse);
        }
        return null;
    }
    public StudentEntity save(StudentEntity student) {
        return repository.save(student);
    }
    public void deleteById(String id) {
        repository.deleteById(id);
    }
}
