package org.idk.studentmanagerweb.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "class")
public class SchoolClass {
    @Id
    @Column(name = "ClassId")
    private int id;
    @Column(name = "ClassName")
    private String className;
    @Column(name = "RoomNumber")
    private String RoomNumber;
    @OneToMany(mappedBy = "schoolClass")
    private List<Student> students;
}
