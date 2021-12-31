package com.company.jcc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RoleController {
    @GetMapping("/role")
    public String getRole() {
        return "role";
    }
}
