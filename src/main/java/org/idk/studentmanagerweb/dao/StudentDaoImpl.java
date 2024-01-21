package org.idk.studentmanagerweb.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
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
}
