package org.idk.studentmanagerweb.advice;

import org.idk.studentmanagerweb.exception.StudentNotFoundException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(StudentNotFoundException.class)
    public String handleStudentNotFoundException(StudentNotFoundException exception, Model model) {
        model.addAttribute("errorMessage", exception.getMessage());
        return "error-page";
    }
}
