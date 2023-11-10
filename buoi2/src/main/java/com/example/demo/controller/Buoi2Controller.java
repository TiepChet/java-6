package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Buoi2Controller {

    @RequestMapping("/hello")
    @ResponseBody
    public String hello(Model model){
        model.addAttribute("mess","FPT Polytechnic");
        return "hello";
    }
}
