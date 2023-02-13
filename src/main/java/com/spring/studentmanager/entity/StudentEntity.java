package com.spring.studentmanager.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "student")
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @NotBlank(message = "Please insert name of student")
    @Column(name = "name")
    private String name;
    @OneToOne(cascade = {CascadeType.ALL})
    @PrimaryKeyJoinColumn
    private StudentDetailEntity studentDetail;

    @ManyToOne
    @JoinColumn(name = "classId")
    private ClassEntity classEntity;

    public StudentEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public StudentDetailEntity getStudentDetail() {
        return studentDetail;
    }

    public void setStudentDetail(StudentDetailEntity studentDetail) {
        this.studentDetail = studentDetail;
    }

    public ClassEntity getClassEntity() {
        return classEntity;
    }

    public void setClassEntity(ClassEntity classEntity) {
        this.classEntity = classEntity;
    }
}
