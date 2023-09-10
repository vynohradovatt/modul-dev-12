package com.example.moduldev12.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;

@Controller
public class TestController {

    @GetMapping(value = "/test")
    public ModelAndView getTime() {
        ModelAndView result = new ModelAndView("test");
        result.addObject("test", "Hello World");
        return result;
    }



}
