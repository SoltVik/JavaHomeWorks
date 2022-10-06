package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import spring.service.TestService;

@Controller
public class SimpleController {
    @Autowired
    TestService testService;

    @GetMapping("/hello")
    public String hello(Model model) {
        testService.test();
        model.addAttribute("name", "Word!");
        return "hello";
    }

    @GetMapping("/")
    public String index(Model model) {
        return "index";
    }
}
