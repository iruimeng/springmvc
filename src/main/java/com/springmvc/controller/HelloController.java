package com.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.logging.Logger;

/**
 * Created by MT on 2017/3/3.
 */
@Controller
public class HelloController {

    private Logger logger = Logger.getLogger(String.valueOf(HelloController.class));


    @GetMapping("/hello")
    public String greeting(@RequestParam(value = "name", required = false, defaultValue = "world") String name, Model model) {
        logger.info("hello come");
        model.addAttribute("name", name);
        return "hello";

    }

}
