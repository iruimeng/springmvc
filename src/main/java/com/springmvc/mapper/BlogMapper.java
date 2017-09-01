package com.springmvc.mapper;

import com.springmvc.model.Blog;

import java.util.ArrayList;


/**
 * Created by MT on 2017/3/2.
 */
public interface BlogMapper {

    public Blog getBlogInfo(int id);

    public ArrayList<Blog> getAll();

    public Integer insert(Blog blog);

}
