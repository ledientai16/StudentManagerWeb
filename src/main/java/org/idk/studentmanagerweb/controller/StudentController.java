package org.idk.studentmanagerweb.controller;

import jakarta.validation.Valid;
import org.idk.studentmanagerweb.entity.Gender;
import org.idk.studentmanagerweb.entity.Student;
import org.idk.studentmanagerweb.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
    private StudentService studentService;
    @Autowired
    public StudentController(StudentService tempStudentService) {
        this.studentService = tempStudentService;
    }
    @GetMapping("/student-list")
    public String showStudentTable(
            @RequestParam(name = "studentName", required = false) String studentName,
            @RequestParam(name = "gender", required = false) Gender theGender,
            @RequestParam(name = "isSearchAll", required = false) Boolean isSearchAll,
            Model model
    )
    {
        System.out.println("Student name : " + studentName);

        List<Student> students;
        if (isSearchAll != null && isSearchAll) {
            students =  this.studentService.findAll();
        } else {
            students =  this.studentService.findStudents(studentName, theGender);
            model.addAttribute("studentName", studentName == null ? "" : studentName);
            model.addAttribute("theGender", theGender == null ? "" : theGender);
        }
        System.out.println(students);
        model.addAttribute("students", students);
        model.addAttribute("genders", Gender.values());

        return "/students/student-info";
    }
    @GetMapping("/student-form")
    public String showStudentForm(Model theModel) {
        Student createStudent = new Student();
        theModel.addAttribute("student", createStudent);
        theModel.addAttribute("gender", Gender.values());
        return "/students/student-form";
    }
    @PostMapping("/student-form")
    public String saveStudent(
            @Valid @ModelAttribute("student") Student student,
            BindingResult bindingResult, Model theModel) {
        theModel.addAttribute("gender", Gender.values());
        if (bindingResult.hasErrors()) {
//            theModel.addAttribute("student", student);
            return "/students/student-form";
        } else {
            studentService.save(student);
            return "redirect:/student/student-list";
        }
    }
    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }
}
