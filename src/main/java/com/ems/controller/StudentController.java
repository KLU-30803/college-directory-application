package com.ems.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {
    
    @GetMapping("/dashboard")
    public String showStudentDashboard() {
        return "student/studentDashboard"; // return to the student's dashboard
    }
    
    @GetMapping("/profile")
    public String showProfile() {
        return "profile"; // return to the student's profile
    }
}


