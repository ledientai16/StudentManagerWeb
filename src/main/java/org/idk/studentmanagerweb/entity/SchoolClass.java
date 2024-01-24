package org.idk.studentmanagerweb.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "class")
public class SchoolClass {
    @Id
    @Column(name = "classid")
    private int id;
    @Column(name = "classname")
    private String className;
    @Column(name = "roomnumber")
    private String roomNumber;
    @OneToMany(mappedBy = "schoolClass")
    private List<Student> students;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        roomNumber = roomNumber;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
