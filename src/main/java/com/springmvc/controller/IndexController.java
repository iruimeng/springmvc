package com.springmvc.controller;


import com.springmvc.model.Blog;
import com.springmvc.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.logging.Logger;

/**
 * Created by MT on 2017/3/2.
 */

@SpringBootApplication
@Controller
//@RequestMapping({"/index"})
public class IndexController {

    private Logger logger = Logger.getLogger(String.valueOf(IndexController.class));


    @Autowired
    private BlogService blogService;


    @GetMapping("/")
    @ResponseBody
    String index() {
        return "index";
    }

    @GetMapping("/blog/{id}")
    @ResponseBody
    public Blog blog(@PathVariable("id") int id, Model model) {

        Blog blog = blogService.getBlogInfo(id);
        if (blog != null) {
            System.out.println("title is:" + blog.getTitle());
            logger.info("content is:" + blog.getContent());
        }
        return blog;
    }

    public static void main(String[] args) {
        SpringApplication.run(IndexController.class);
    }
}
