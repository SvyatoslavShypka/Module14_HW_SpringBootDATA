package com.goit.module14_hw_springdata.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/")
@Controller
public class TestControler {

    @GetMapping("/test")
    public ModelAndView test() {

        return new ModelAndView("test");
    }
}
