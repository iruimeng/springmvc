package com.springmvc.model;

/**
 * Created by mengrui-g on 2017/9/1.
 */

import lombok.Data;

@Data
public class User {

    private Integer uid;

    private String name;

    private String email;

    private String pwd;
}
