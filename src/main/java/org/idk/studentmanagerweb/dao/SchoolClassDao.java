package org.idk.studentmanagerweb.dao;

import org.idk.studentmanagerweb.entity.SchoolClass;

import java.util.List;

public interface SchoolClassDao {
    List<SchoolClass> findAll();
    List<SchoolClass> findSchoolClasses(String className, String roomName);
    SchoolClass findClassById(Integer id);
}
