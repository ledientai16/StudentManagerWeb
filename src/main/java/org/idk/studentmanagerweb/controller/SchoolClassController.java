package org.idk.studentmanagerweb.controller;

import org.idk.studentmanagerweb.entity.SchoolClass;
import org.idk.studentmanagerweb.entity.Student;
import org.idk.studentmanagerweb.service.SchoolClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/class")
public class SchoolClassController {
    private SchoolClassService schoolClassService;
    @Autowired
    public SchoolClassController(SchoolClassService tempSchoolClassService) {
        schoolClassService = tempSchoolClassService;
    }
    @GetMapping("/class-list")
    public String showClassList(
            @RequestParam(name = "className", required = false) String className,
            @RequestParam(name = "roomName", required = false) String roomName,
            @RequestParam(name = "isSearchAll", required = false) Boolean isSearchAll,
            Model model
    ) {
        List<SchoolClass> schoolClassList;
        if (isSearchAll != null && isSearchAll) {
            schoolClassList = schoolClassService.findALl();
        } else {
            schoolClassList = schoolClassService.findSchoolClasses(className, roomName);
        }
        model.addAttribute("schoolList", schoolClassList);
        model.addAttribute("className", className);
        model.addAttribute("roomName", roomName);
        return "/school-class/class-list";
    }
    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }
}
