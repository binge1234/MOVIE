package com.lzb.movie.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lzb.movie.util.SpringContextHolder;
 
@Controller
public class IndexController {
 
    @RequestMapping("/register")
    public String hello() {
        return "front/user/register";
    }
    @RequestMapping("/index")
    public String hello1() {
        return "front/user/index";
    }
    
 
}