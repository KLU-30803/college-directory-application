package com.ems.controller;

import com.ems.entity.User;
import com.ems.entity.Role;
import com.ems.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    // Register Page
    @GetMapping("/register")
    public String showRegisterPage() {
        return "register"; // return to register.html
    }

    // Handle Registration
    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user, Model model) {
        User existingUser = userService.findByUsername(user.getUsername());
        if (existingUser != null) {
            model.addAttribute("error", "Username already exists!");
            return "register";
        }
        userService.save(user);
        model.addAttribute("success", "Registration successful!");
        return "redirect:/user/login";
    }

    // Login Page
    @GetMapping("/login")
    public String showLoginPage() {
        return "login"; // return to login.html
    }

    // Handle Login
    @PostMapping("/login")
    public String loginUser(@RequestParam String username, 
                            @RequestParam String password, 
                            @RequestParam Role role, 
                            Model model) {
        User user = userService.findByUsername(username);
        if (user == null || !user.getPassword().equals(password)) {
            model.addAttribute("error", "Invalid username or password!");
            return "login";
        }
        if (user.getRole() != role) {
            model.addAttribute("error", "Invalid role selected!");
            return "login";
        }

        switch (role) {
            case STUDENT:
                return "redirect:/student/dashboard";
            case FACULTY_MEMBER:
                return "redirect:/faculty/dashboard";
            case ADMINISTRATOR:
                return "redirect:/admin/dashboard";
            default:
                return "login";
        }
    }

}
