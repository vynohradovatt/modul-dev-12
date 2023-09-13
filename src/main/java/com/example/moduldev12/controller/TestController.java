package com.example.moduldev12.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {

    @GetMapping(value = "/test")
    public ModelAndView getTime() {
        ModelAndView result = new ModelAndView("test");
        result.addObject("test", "Hello World");
        return result;
    }



}
