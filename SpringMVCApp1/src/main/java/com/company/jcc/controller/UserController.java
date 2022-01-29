package com.company.jcc.controller;

import com.company.jcc.model.Rent;
import com.company.jcc.model.User;
import com.company.jcc.service.impl.RentServiceImpl;
import com.company.jcc.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    private final UserServiceImpl userServiceImpl;

    @Autowired
    private final RentServiceImpl rentService;

    public UserController(UserServiceImpl userServiceImpl, RentServiceImpl rentService) {
        this.userServiceImpl = userServiceImpl;
        this.rentService = rentService;
    }
//    @Autowired
//    private final RoleServiceImpl roleServiceImpl;
//
//

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("user", new User());
        return "create_user";
    }

    @PostMapping("/create")
    public String create(@Validated @ModelAttribute("user") User user) {
        User newUser = userServiceImpl.create(user);
        newUser.setDateRegistered(LocalDate.now());
        return "redirect:/users/all";
    }

    @GetMapping("/{id}/read")
    public String read(@PathVariable int id, Model model) {
        User user = userServiceImpl.readById(id);
        List<Rent> rent = rentService.hasRead(id);
        LocalDate date = user.getDateRegistered();
        Period period = Period.between(date, LocalDate.now());
        model.addAttribute("user", user);
        model.addAttribute("rents", rent);
        model.addAttribute("period", period);
        return "user_info";
    }

    @GetMapping("/all")
    public String getAll(Model model) {
        model.addAttribute("users", userServiceImpl.getAll());
        return "user_list";
    }

    @GetMapping("/{id}/update")
    public String update(@PathVariable int id, Model model) {
        User user = userServiceImpl.readById(id);
        model.addAttribute("user", user);
//        model.addAttribute("roles", .getAll());
        System.out.println(user + "get method");
        return "update_user";
    }

    @PostMapping("/{id}/update")
    public String update(@PathVariable(name = "id") int id, @RequestParam String name,
                         @RequestParam String surname,
                         @RequestParam() String password,
                         @RequestParam String email) {
        User user = userServiceImpl.readById(id);
        System.out.println(user);
        user.setName(name);
        user.setSurname(surname);
        user.setEmail(email);
        user.setUsername(email);
        if (password != null) {
            user.setPassword(password);
        }
        userServiceImpl.update(user);
        return "redirect:/users/" + id + "/read";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable("id") int id) {
        userServiceImpl.delete(id);
        return "redirect:/users/all";
    }

}
