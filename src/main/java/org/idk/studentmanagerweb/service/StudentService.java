package org.idk.studentmanagerweb.service;

import org.idk.studentmanagerweb.entity.Gender;
import org.idk.studentmanagerweb.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> findAll();
    List<Student> findStudents(String name, Gender gender);
    void save(Student student);
}
