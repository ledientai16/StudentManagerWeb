package org.idk.studentmanagerweb.service;

import org.idk.studentmanagerweb.dao.SchoolClassDao;
import org.idk.studentmanagerweb.entity.SchoolClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SchoolClassServiceImpl implements SchoolClassService{
    private SchoolClassDao schoolClassDao;
    @Autowired
    public SchoolClassServiceImpl (SchoolClassDao tempSchoolClassDao) {
        schoolClassDao = tempSchoolClassDao;
    }
    @Override
    public List<SchoolClass> findALl() {
        return schoolClassDao.findAll();
    }
}
