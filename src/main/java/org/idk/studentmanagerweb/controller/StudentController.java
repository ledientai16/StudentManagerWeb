package org.idk.studentmanagerweb.controller;

import org.idk.studentmanagerweb.entity.Gender;
import org.idk.studentmanagerweb.entity.Student;
import org.idk.studentmanagerweb.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class StudentController {
    private StudentService studentService;
    @Autowired
    public StudentController(StudentService tempStudentService) {
        this.studentService = tempStudentService;
    }
    @GetMapping("/student")
    public String showStudentTable(
            @RequestParam(name = "studentName", required = false) String studentName,
            @RequestParam(name = "gender", required = false) Gender theGender,
            Model model
    )
    {
        System.out.println("Student name : " + studentName);
        List<Student> students =  this.studentService.findStudents(studentName, theGender);
        System.out.println(students);
        model.addAttribute("students", students);
        model.addAttribute("genders", Gender.values());

        model.addAttribute("studentName", studentName.isBlank() ? "" : studentName);
        model.addAttribute("theGender", theGender == null ? "" : theGender);
        return "/students/student-info";
    }
    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
         StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }
}
