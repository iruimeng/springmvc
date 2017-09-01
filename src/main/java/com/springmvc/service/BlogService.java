package com.springmvc.service;

import com.springmvc.mapper.BlogMapper;
import com.springmvc.model.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by MT on 2017/3/3.
 */

@Service
public class BlogService {

    @Autowired
    private BlogMapper blogMapper;

    public Blog getBlogInfo(int id) {
        Blog blog = blogMapper.getBlogInfo(id);
        return blog;
    }

    public ArrayList<Blog> getAll() {
        ArrayList<Blog> blogs = blogMapper.getAll();
        return blogs;
    }

    public Integer insert(Blog blog) {


        SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");

        String ctime = df.format(new Date());
        blog.setCtime(ctime);

        return blogMapper.insert(blog);
    }
}
