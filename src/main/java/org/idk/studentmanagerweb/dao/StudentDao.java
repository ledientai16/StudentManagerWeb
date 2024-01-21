package org.idk.studentmanagerweb.dao;

import org.idk.studentmanagerweb.entity.Student;

import java.util.List;

public interface StudentDao {
    List<Student> findAll();
}
