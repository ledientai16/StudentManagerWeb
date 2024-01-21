package org.idk.studentmanagerweb.controller;

import org.idk.studentmanagerweb.entity.Student;
import org.idk.studentmanagerweb.service.StudentService;
import org.idk.studentmanagerweb.service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class StudentController {
    private StudentService studentService;
    @Autowired
    public StudentController(StudentService tempStudentService) {
        this.studentService = tempStudentService;
    }
    @GetMapping("/student")
    public String showStudentTable(Model model) {
        List<Student> students =  this.studentService.findAll();
        System.out.println(students);
        model.addAttribute("students", students);
        return "student-info";
    }
}
