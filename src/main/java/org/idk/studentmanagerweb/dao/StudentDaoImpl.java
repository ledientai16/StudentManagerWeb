package org.idk.studentmanagerweb.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.idk.studentmanagerweb.entity.Gender;
import org.idk.studentmanagerweb.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDaoImpl implements StudentDao{
    private EntityManager entityManager;
    @Autowired
    public StudentDaoImpl(EntityManager tempEntityManager) {
        entityManager = tempEntityManager;
    }
    @Override
    public List<Student> findAll() {
        TypedQuery<Student> query= entityManager.createQuery(
                "FROM Student",
                Student.class
        );
        return query.getResultList();
    }

    @Override
    public List<Student> findStudents(String name, Gender gender) {
        String JPQL  = "From Student s " +
                "Where (s.lastName like :name " +
                "OR s.firstName like :name ) ";
        if (gender != null) {
            JPQL  += "AND gender = :gender";
        }
        TypedQuery<Student> query = entityManager.createQuery(JPQL , Student.class);
        query.setParameter("name", "%" + name + "%");
        if (gender != null) {
            query.setParameter("gender", gender);
        }
        return query.getResultList();
    }
    @Override
    public void save(Student student) {
        entityManager.merge(student);
    }

    @Override
    public Student findStudentById(Integer id) {
        Student findStudent = entityManager.find(Student.class, id);

        return findStudent;
    }

    @Override
    public void deleteStudent(Student delStudent) {
        entityManager.remove(delStudent);
    }
}
