package com.spring.studentmanager.entity;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "studentdetail")
public class StudentDetailEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @NotBlank(message = "Please insert address")
    @Column(name="address")
    private String address;

    //    @NotBlank(message = "Please insert number of page")
    @Column(name = "gender")
    private String gender;

    @OneToOne(mappedBy = "studentDetail")
    private StudentEntity studentEntity;

    public StudentDetailEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public StudentEntity getStudentEntity() {
        return studentEntity;
    }

    public void setStudentEntity(StudentEntity studentEntity) {
        this.studentEntity = studentEntity;
    }
}

