package com.lzb.movie.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
 
@Controller
public class HelloController {
 
    @RequestMapping("/register")
    public String hello() {
        return "admin/register";
    }
    @RequestMapping("/index")
    public String hello1() {
        return "admin/index";
    }
    
 
}