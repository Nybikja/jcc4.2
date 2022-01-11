package com.company.jcc.controller;

import com.company.jcc.model.RegUser;
import com.company.jcc.service.RegUserService;
import com.company.jcc.service.impl.RegUserServiceImpl;
import com.company.jcc.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MainController {

    @Autowired
    private UserServiceImpl userService;


    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/-error")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "login";
    }

    @GetMapping("/")
    public String home(Model model, HttpServletRequest request){
        model.addAttribute("x", "hello");
        return "hello_world";
    }

    @GetMapping("/xxx")
    public String xxx(){
        return "redirect:/";
    }

    @PostMapping("/success")
    public String success(){
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!");
        return "redirect:/";
    }

    @Autowired
    private RegUserService regUserService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/saveMe")
    public String saveMe(RegUser regUser){
        String encode = passwordEncoder.encode(regUser.getPassword());
        regUser.setPassword(encode);
        regUserService.create(regUser);
        return "redirect:/";
    }

//
//    @RequestMapping("/login-error")
//    public String loginError(Model model) {
//        model.addAttribute("loginError", true);
//        return "error";
//    }
}
