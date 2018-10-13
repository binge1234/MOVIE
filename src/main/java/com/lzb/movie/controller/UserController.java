package com.lzb.movie.controller;


import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 
 * @since 2018-10-13
 */
@Controller
@RequestMapping("/user")
public class UserController {
	
	//跳转到注册界面
    @RequestMapping("/register")
    public String hello() {
        return "admin/register";
    }
    //跳转到登录界面
    @RequestMapping("/index")
    public String hello1() {
        return "admin/index";
    }
    
}

