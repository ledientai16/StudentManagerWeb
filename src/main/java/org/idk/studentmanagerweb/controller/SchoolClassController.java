package org.idk.studentmanagerweb.controller;

import jakarta.validation.Valid;
import org.idk.studentmanagerweb.entity.SchoolClass;
import org.idk.studentmanagerweb.entity.Student;
import org.idk.studentmanagerweb.service.SchoolClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/class-form")
    public String showClassForm(Model theModel) {
        theModel.addAttribute("schoolCls", new SchoolClass());
        System.out.println("schoolClass: " );
        return "/school-class/class-form";
    }

    @PostMapping("/class-form")
    public String saveClass(
            @Valid @ModelAttribute("schoolCls") SchoolClass schoolClass,
            BindingResult bindingResult,
            Model theModel
    ) {
        System.out.println("schoolClassasassa : " + schoolClass.getClassName());
        System.out.println("schoolClassasassa : " + schoolClass.getRoomNumber());
        if (bindingResult.hasErrors()) {
            return "/school-class/class-form";
        } else{
            schoolClassService.save(schoolClass);
            return "redirect:/class/class-form";
        }
    }
    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }
}
