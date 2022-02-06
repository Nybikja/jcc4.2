package com.company.jcc.controller;

import com.company.jcc.config.EmailService;
import com.company.jcc.model.User;
import com.company.jcc.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private EmailService emailService;

    @Autowired
    private UserServiceImpl userService;

    public AdminController(EmailService emailService, UserServiceImpl userService) {
        this.emailService = emailService;
        this.userService = userService;
    }

    @GetMapping("users/all")
    public String getAll(Model model) {
        model.addAttribute("users", userService.getAll());
        return "user_list";
    }

    @GetMapping("/email/{id}")
    public String email(@PathVariable("id") int id){
//        List<User> users = userService.getAll();
        User user = userService.readById(id);
        String email = user.getEmail();
        emailService.sendSimpleMessage("hello", "test from my app", email);
        return "redirect:/";
    }

    @GetMapping("/email/all")
    public String email(){
        List<User> users = userService.getAll();
        for (User user: users) {
            String email = user.getEmail();
            emailService.sendSimpleMessage("hello", "test from my app", email);
        }
        return "redirect:/";
    }
}
