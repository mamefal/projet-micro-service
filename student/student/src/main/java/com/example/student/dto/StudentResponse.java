package com.example.student.dto;

public class StudentResponse {
    private String id;
    private String name;
    private String genre;
    private SchoolResponse school;

    // All-args constructor
    public StudentResponse(String id, String name, String genre, SchoolResponse school) {
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.school = school;
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGenre() {
        return genre;
    }

    public SchoolResponse getSchool() {
        return school;
    }

    // Setters
    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setSchool(SchoolResponse school) {
        this.school = school;
    }
}
