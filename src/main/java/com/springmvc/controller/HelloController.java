package com.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.logging.Logger;

/**
 * Created by MT on 2017/3/3.
 */
@Controller
public class HelloController {

    private Logger logger = Logger.getLogger(String.valueOf(HelloController.class));

    /*@Autowired
    public HttpServletRequest request;*/


    @GetMapping("/hello")
    public String greeting(@RequestParam(value = "name", required = false, defaultValue = "world") String name, Model model) {
        logger.info("hello come");
        model.addAttribute("name", name);
        return "hello";

    }

    @GetMapping("/t/**")
    @ResponseBody
    public ModelAndView t1(ModelAndView view) {
        view.setViewName("/hello");
        view.addObject("attr", "t1->/t/**");
        return view;
    }

    /*@GetMapping("/t*//*")
    @ResponseBody
    public ModelAndView t2(ModelAndView view) {
        view.setViewName("/hello");
        view.addObject("attr", "t2->/t*//*");
        return view;
    }*/

    @GetMapping("t?")
    @ResponseBody
    public ModelAndView t3(ModelAndView view) {
        view.setViewName("/hello");
        view.addObject("attr", "t?");
        return view;
    }

    @GetMapping("t/*")
    @ResponseBody
    public ModelAndView t4(ModelAndView view, HttpSession session) {
        //session.setAttribute();

        view.setViewName("/hello");
        view.addObject("attr", "t/*");
        return view;
    }

    @GetMapping("/req/*")
    @ResponseBody
    public String req(HttpServletRequest request, Model model) {
        model.addAttribute("name", "world");
        ArrayList<String> l = new ArrayList<>();
        System.out.println(request);
        System.out.println(request.getCookies());
        System.out.println(request.getCookies().toString());
        return "hello";
    }

}
