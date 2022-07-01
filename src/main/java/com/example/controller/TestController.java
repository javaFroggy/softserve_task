package com.example.controller;

import com.example.model.Test;
import com.example.model.User;
import com.example.service.TestService;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.List;

@Controller
public class TestController {

    private final TestService testService;
    private final UserService userService;

    @Autowired
    public TestController(TestService testService, UserService userService) {
        this.testService = testService;
        this.userService = userService;
    }

    @GetMapping("/tests")
    public String listTests(Model model){
        List<Test> tests = testService.getAllTests();
        model.addAttribute("tests", tests);
        return "testsPage";
    }

    @PreAuthorize("hasAuthority('user:write')")
    @GetMapping("/addTest")
    public String addTest(Model model, Principal principal){
        String username = principal.getName();

        model.addAttribute("creator_username", username);
        return "addTest";

    }

    @PreAuthorize("hasAuthority('user:write')")
    @PostMapping("/addTest")
    public String addTest(Model model,
                          @RequestParam("name")String test_name,
                          @RequestParam("test_theme")String theme,
                          @RequestParam("creator_username")String username,
                          @RequestParam("description")String desc
                          ){
        User creator = userService.findByUserName(username);

        Test test = Test.builder()
                .testName(test_name)
                .testTheme(theme)
                .creator(creator)
                .testDescription(desc)
                .build();

        testService.saveTest(test);

        return "redirect:/management/manageTests";
    }
}
