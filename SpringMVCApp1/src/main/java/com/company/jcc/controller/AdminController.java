package com.company.jcc.controller;

import com.company.jcc.config.EmailService;
import com.company.jcc.model.Book;
import com.company.jcc.model.Rent;
import com.company.jcc.model.User;
import com.company.jcc.service.impl.BookServiceImpl;
import com.company.jcc.service.impl.RentServiceImpl;
import com.company.jcc.service.impl.RequestServiceImpl;
import com.company.jcc.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private EmailService emailService;

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private RequestServiceImpl requestService;

    @Autowired
    private RentServiceImpl rentService;

    public AdminController(EmailService emailService, UserServiceImpl userService, RequestServiceImpl requestService) {
        this.emailService = emailService;
        this.userService = userService;
        this.requestService = requestService;
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

    @GetMapping("/users/statistic")
    public String statistic(){
        return "users_statistic";
    }

    @PostMapping("/users/admin/users/statistic")
    public String userStatistic(
            @RequestParam("dateStart") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateStart,
            @RequestParam("dateEnd") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateEnd,
            Model model) {
        List<User> users = userService.getAll();
        long days = 0;
        for (User u: users) {
            long period = ChronoUnit.DAYS.between(u.getDateRegistered(), LocalDate.now());
            days += period;
        }
        int avg = (int) (days / users.size());
        model.addAttribute("dateStart", dateStart);
        model.addAttribute("dateEnd", dateEnd);
        model.addAttribute("avgAge", userService.avgAge());
        model.addAttribute("avgTime", avg);
        model.addAttribute("avgRequest", requestService.avgRequest(dateStart, dateEnd));
        System.out.println(requestService.avgRequest(dateStart, dateEnd));
        return "users_statistic2";
    }

    @GetMapping("/users/debtors")
    public String notReturned(Model model){
        model.addAttribute("users", rentService.findUsersNotReturnedInTime());
        return "debtors";
    }

}
