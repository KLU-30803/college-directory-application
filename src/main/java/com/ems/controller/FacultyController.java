package com.ems.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/faculty")
public class FacultyController {
    
    @GetMapping("/dashboard")
    public String showFacultyDashboard() {
        return "faculty/facultyDashboard";
    }
    
    @GetMapping("/profile")
    public String showProfile() {
        return "facultyProfile";
    }
}