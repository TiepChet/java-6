package com.example.demo.controller;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello(Model model){
        model.addAttribute("mess","<h3>Hello Thymeleaf</h3>");
        return "hello";
    }
}
