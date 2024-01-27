package org.idk.studentmanagerweb.service;

import org.idk.studentmanagerweb.dao.StudentDao;
import org.idk.studentmanagerweb.dao.StudentDaoImpl;
import org.idk.studentmanagerweb.entity.Gender;
import org.idk.studentmanagerweb.entity.Student;
import org.idk.studentmanagerweb.exception.StudentNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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
    @Override
    @Transactional
    public void save(Student student) {
        studentDao.save(student);
    }

    @Override
    public Student findStudentById(Integer id) {
        Optional<Student> findStudent = Optional.ofNullable(studentDao.findStudentById(id));

        return findStudent.orElseThrow(() -> new StudentNotFoundException("Student not found"));
    }

    @Override
    @Transactional
    public void deleteStudent(Student delStudent) {
        studentDao.deleteStudent(delStudent);
    }
}
