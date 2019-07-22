package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/u")
public class UserspaceController {//用户空间功能：背包(个人设置页)、收藏的地方

    @GetMapping("/{userName}")
    public String usserSpace(){
        return "/userSpace/u";
    }

    @GetMapping("/{userName}/bag")
    public String bag(){
        return "bag";
    }

    @GetMapping("/{userName}/favor")
    public String favor(){
        return "favor";
    }

}
