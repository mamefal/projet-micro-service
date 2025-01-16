package com.example.school.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "school")
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    private String directorName;

    public School(Long id, String name, String address, String directorName) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.directorName = directorName;
    }

    public School() {

    }

    public void setId(Long id) {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }
    // Getters, setters, etc.
}
