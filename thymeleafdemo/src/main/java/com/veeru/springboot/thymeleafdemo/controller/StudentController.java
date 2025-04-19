package com.veeru.springboot.thymeleafdemo.controller;

import com.veeru.springboot.thymeleafdemo.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {

    @Value("${countries}")
    private List<String> countries;

    @Value("${languages}")
    private List<String> languages;

    @Value("${systems}")
    private List<String> systems;

    @GetMapping("/showStudentForm")
    public String showStudentForm(Model model) {

        Student thestudent = new Student();

        model.addAttribute("student", thestudent);

        model.addAttribute("countries", countries);

        model.addAttribute("languages", languages);

        model.addAttribute("systems",systems);

        return "student-form";
    }

    @PostMapping("/processStudentForm")
    public String processForm(@ModelAttribute("student") Student theStudent) {

        System.out.println("The Student : " + theStudent.getFirstName() + " " + theStudent.getLastName());

        return "student-confirmation";
    }
}
