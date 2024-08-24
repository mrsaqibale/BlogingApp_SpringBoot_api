package com.blog.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class HomeCont {
    @RequestMapping("/index")
    public String index(){
        return "index page call for public users only ";
        }
}
