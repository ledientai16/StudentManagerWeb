package org.idk.studentmanagerweb.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.idk.studentmanagerweb.entity.SchoolClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class SchoolClassDaoImpl implements SchoolClassDao{
    private EntityManager entityManager;
    @Autowired
    public SchoolClassDaoImpl(EntityManager tempEntityManager) {
        entityManager = tempEntityManager;
    }
    @Override
    public List<SchoolClass> findAll() {
        TypedQuery<SchoolClass> query = entityManager.createQuery(
                "FROM SchoolClass",
                SchoolClass.class
        );
        return query.getResultList();
    }

    @Override
    public List<SchoolClass> findSchoolClasses(String className, String roomName) {
        String jpql = "FROM SchoolClass " +
                "Where className like :className " +
                "And roomNumber like :roomName";

        TypedQuery<SchoolClass> query = entityManager.createQuery(jpql, SchoolClass.class);
        query.setParameter("className", "%" + className + "%");
        query.setParameter("roomName", "%" + roomName + "%");

        return query.getResultList();
    }
}
