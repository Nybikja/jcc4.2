package com.company.jcc.controller;

import com.company.jcc.model.User;
import com.company.jcc.service.RoleService;
import com.company.jcc.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final RoleService roleService;

    public UserController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("user", new User());
        return "create_user";
    }

    @PostMapping("/create")
    public String create(@Validated @ModelAttribute("user") User user) {
        user.setRole(roleService.readById(2));
        User newUser = userService.create(user);
        return "redirect:/users/" + newUser.getId() + "/read";
    }

    @GetMapping("/{id}/read")
    public String read(@PathVariable int id, Model model) {
        User user = userService.readById(id);
        model.addAttribute("user", user);
        return "user_info";
    }

    @GetMapping("/all")
    public String getAll(Model model) {
        model.addAttribute("users", userService.getAll());
        return "user_list";
    }

    @GetMapping("/{id}/update")
    public String update(@PathVariable int id, Model model) {
        User user = userService.readById(id);
        model.addAttribute("user", user);
        model.addAttribute("roles", roleService.getAll());
        System.out.println(user + "get method");
        return "update_user";
    }
//
//    @PostMapping("/{id}/update")
//    public String update(Model model, @ModelAttribute("user") User user, @PathVariable(name = "id") int id) {
//        User oldUser = userService.readById(user.getId());
//        System.out.println(user);
//        user.setRole(oldUser.getRole());
//        model.addAttribute("roles", roleService.getAll());
//        user.setRole(oldUser.getRole());
//        userService.update(user);
//        return "redirect:/users/" + user.getId() + "/read";
//    }

    @PostMapping("/{id}/update")
    public String update(@PathVariable(name = "id") int id, @RequestParam String name,
                         @RequestParam String surname,
                         @RequestParam String password) {
        User user = userService.readById(id);
        System.out.println(user);
        user.setName(name);
        user.setSurname(surname);
        if(password != null){
            user.setPassword(password);
        }
        userService.update(user);
        return "redirect:/users/" + id + "/read";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable("id") int id) {
        userService.delete(id);
        return "redirect:/users/all";
    }


}
