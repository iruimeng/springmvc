package com.springmvc.service;

import com.springmvc.mapper.UserMapper;
import com.springmvc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by mengrui-g on 2017/9/1.
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User getByEmail(String email) {
        return userMapper.getByEmail(email);
    }
}
