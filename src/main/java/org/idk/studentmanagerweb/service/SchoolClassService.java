package org.idk.studentmanagerweb.service;

import org.idk.studentmanagerweb.entity.SchoolClass;

import java.util.List;

public interface SchoolClassService {
    List<SchoolClass> findALl();

    List<SchoolClass> findSchoolClasses(String className, String roomName);

    void save(SchoolClass schoolClass);
}
