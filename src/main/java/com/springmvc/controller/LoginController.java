package com.springmvc.controller;

import com.springmvc.model.User;
import com.springmvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * Created by mengrui-g on 2017/8/31.
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserService userService;


    @RequestMapping(method = RequestMethod.GET)
    public String index() {
        return "login/index";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String login(@RequestParam(value = "email") String email,
                        @RequestParam(value="pwd") String pwd, HttpSession session) {
        User user = userService.getByEmail(email);
        System.out.println(user);

        if (user.getPwd().equals(pwd)) {
            session.setAttribute("uid", user.getUid());
        } else {
            return "redirect:/login?pwd=error";
        }

        return "redirect:/";
    }


    @RequestMapping(value = "/reg", method = RequestMethod.GET)
    public String reg() {
        return "login/reg";
    }
}
