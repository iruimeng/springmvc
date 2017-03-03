package com.springmvc.service;

import com.springmvc.mapper.BlogMapper;
import com.springmvc.model.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
