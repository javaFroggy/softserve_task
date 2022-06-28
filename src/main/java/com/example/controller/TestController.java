package com.example.controller;

import com.example.model.Test;
import com.example.service.TestService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class TestController {

    private final TestService testService;

    public TestController(TestService testService) {
        this.testService = testService;
    }

    @GetMapping("/tests")
    public String listTests(Model model){
        List<Test> tests = testService.getAllTests();
        model.addAttribute("tests", tests);
        return "testsPage";
    }


}
