package com.example.controller;

import com.example.model.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/management")
public class ManagementController {

    private final UserService userService;

    @Autowired
    public ManagementController(UserService userService) {
        this.userService = userService;
    }

    @PreAuthorize("hasAuthority('user:write')")
    @GetMapping("/manageUsers")
    public String manageUsers(Model model){
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "admin/manageUsers";
    }

    @PreAuthorize("hasAuthority('user:write')")
    @GetMapping("/manageTests")
    public String manageTests(Model model){
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "admin/manageUsers";
    }
}
