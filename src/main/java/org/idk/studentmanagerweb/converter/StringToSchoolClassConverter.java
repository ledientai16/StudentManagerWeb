package org.idk.studentmanagerweb.converter;

import org.idk.studentmanagerweb.dao.SchoolClassDao;
import org.idk.studentmanagerweb.dao.StudentDao;
import org.idk.studentmanagerweb.entity.SchoolClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class StringToSchoolClassConverter implements Converter<String, SchoolClass> {
    private final SchoolClassDao schoolClassDao;
    @Autowired
    public StringToSchoolClassConverter(SchoolClassDao tempSchoolClassDao) {
        schoolClassDao = tempSchoolClassDao;
    }
    @Override
    public SchoolClass convert(String id) {
        if (id == null || id.isEmpty()) {
            return null;
        }
        Integer classId = Integer.valueOf(id);
        Optional<SchoolClass> schoolClass = Optional.ofNullable(schoolClassDao.findClassById(classId));
        return schoolClass.orElse(null);
    }
}
