package org.idk.studentmanagerweb.service;

import org.idk.studentmanagerweb.dao.StudentDao;
import org.idk.studentmanagerweb.dao.StudentDaoImpl;
import org.idk.studentmanagerweb.entity.Gender;
import org.idk.studentmanagerweb.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    private StudentDao studentDao;
    @Autowired
    public StudentServiceImpl(StudentDao studentDao) {
        this.studentDao = studentDao;
    }
    @Override
    public List<Student> findAll() {
        List<Student> students = studentDao.findAll();
        return students;
    }
    @Override
    public List<Student> findStudents(String name, Gender gender) {
        List<Student> students = studentDao.findStudents(name, gender);
        return students;
    }
}
