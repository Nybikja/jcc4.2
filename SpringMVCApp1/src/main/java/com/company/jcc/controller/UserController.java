package com.company.jcc.controller;

import com.company.jcc.model.User;
import com.company.jcc.service.impl.RoleServiceImpl;
import com.company.jcc.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    private final UserServiceImpl userServiceImpl;
    @Autowired
    private final RoleServiceImpl roleServiceImpl;

    public UserController(UserServiceImpl userService, RoleServiceImpl roleService) {
        this.userServiceImpl = userService;
        this.roleServiceImpl = roleService;
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("user", new User());
        return "create_user";
    }

    @PostMapping("/create")
    public String create(@Validated @ModelAttribute("user") User user) {
        user.setRole(roleServiceImpl.readById(2));
        User newUser = userServiceImpl.create(user);
        return "redirect:/users/" + newUser.getId() + "/read";
    }

    @GetMapping("/{id}/read")
    public String read(@PathVariable int id, Model model) {
        User user = userServiceImpl.readById(id);
        model.addAttribute("user", user);
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
        model.addAttribute("roles", roleServiceImpl.getAll());
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
