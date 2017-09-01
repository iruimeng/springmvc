package com.springmvc.mapper;

import com.springmvc.model.User;

/**
 * Created by mengrui-g on 2017/9/1.
 */
public interface UserMapper {
    User getByEmail(String email);
}
