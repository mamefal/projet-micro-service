package com.example.student.dto;

public class SchoolResponse {
    private Long id;
    private String name;
    private String address;
    private String directorName;

    // All-args constructor
    public SchoolResponse(Long id, String name, String address, String directorName) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.directorName = directorName;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getDirectorName() {
        return directorName;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }
}
