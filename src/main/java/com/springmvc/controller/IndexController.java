package com.springmvc.controller;


import com.springmvc.model.Blog;
import com.springmvc.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;
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


    @GetMapping(value = {"/", "/index"})
    public String index(Model model, HttpSession session) {

        List<Blog> blogs = blogService.getAll();

        /*for (Blog blog: blogs) {
            System.out.println(blog);
        }*/
        model.addAttribute("posts", blogs);

        model.addAttribute("uid", session.getAttribute("uid"));

        return "index";
    }

    @GetMapping(value = {"/blog/{id}"})
    @ResponseBody
    public Blog blog(@PathVariable("id") int id) {

        Blog blog = blogService.getBlogInfo(id);
        if (blog != null) {
            System.out.println("title is:" + blog.getTitle());
            logger.info("content is:" + blog.getContent());
        }
        return blog;
    }



    @GetMapping({"/blog/edit"})
    public String edit(HttpSession session) {
        if (session.getAttribute("uid") == null) {
            return "redirect:/";
        }
        return "edit";
    }

    //public ModelAndView t() {

    //}

    @RequestMapping(value = "/blog/save", method = RequestMethod.POST)
    public String save(Blog blog) {

        //@RequestParam("title") String title,
        //@RequestParam("content") String content, Model model

        System.out.println(blog);
        //默认返回结果是影响行数
        int num = blogService.insert(blog);

        logger.info(String.valueOf(blog.getId()));
        logger.info(String.valueOf(num));
        //xml配置useGeneratedKeys="true" keyProperty="id"。可以在对象里面获取插入新增主键
        return "redirect:/blog/" + blog.getId();
    }

}
