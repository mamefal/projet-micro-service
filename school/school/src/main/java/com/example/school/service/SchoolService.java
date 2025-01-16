package com.example.school.service;

import com.example.school.entity.School;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.school.repository.SchoolRepository;
import java.util.List;
@Service
public class SchoolService {
    @Autowired
    private SchoolRepository repository;

    public List<School> findAll() { return repository.findAll(); }
    public School findById(Long id) { return repository.findById(id).orElse(null); }
    public School save(School school) { return repository.save(school); }
    public void deleteById(Long id) { repository.deleteById(id); }
}

