package com.ivoyant.SpringKubernates.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;

@Entity
public class Student {
    @Id // adds a primary key
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String regNo;
    private String course;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getName() {
        return name;
    }

    public String getRegNo() {
        return regNo;
    }

    public String getCourse() {
        return course;
    }

    public Student() {
    }

    public Student(Long id, String name, String regNo, String course) {
        this.id = id;
        this.name = name;
        this.regNo = regNo;
        this.course = course;
    }


}