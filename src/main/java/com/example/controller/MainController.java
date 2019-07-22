package com.example.controller;

import com.example.entity.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {//整个系统相关控制：登陆、注册、退出
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String root(){
        return "redirect:/index";
    }

    @GetMapping("/index")
    public String index(){
        return "index";
    }

    @GetMapping("/login")//登陆
    public String logon(){
        return "login";
    }

    @GetMapping("/login-error")//登陆失败
    public String loginError(Model model){
        model.addAttribute("loginError",true);
        model.addAttribute("errorMsg","登陆失败，用户名或密码错误！");
        return "login";
    }

    @GetMapping("/register")//注册
    public String register(){
        return "register";
    }

    /**
     * 注册用户
     * @param user
     * @return
     */
    @PostMapping("/register")
    public String registerUser(User user){
        userService.registerUser(user);
        return "redirect:/login";
    }
}
