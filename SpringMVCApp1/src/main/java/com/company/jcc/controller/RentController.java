package com.company.jcc.controller;

import com.company.jcc.model.Book;
import com.company.jcc.model.Rent;
import com.company.jcc.model.User;

import com.company.jcc.service.impl.BookServiceImpl;
import com.company.jcc.service.impl.RentServiceImpl;
import com.company.jcc.service.impl.UserServiceImpl;
import org.joda.time.DateTime;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;

@Controller
@RequestMapping("/rent")
public class RentController {
    private final RentServiceImpl rentService;
    private final BookServiceImpl bookService;
    private final UserServiceImpl userService;


    public RentController(RentServiceImpl rentService, BookServiceImpl bookService, UserServiceImpl userService) {
        this.rentService = rentService;
        this.bookService = bookService;
        this.userService = userService;
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("rent", new Rent());
        model.addAttribute("books", bookService.getAll());
        model.addAttribute("users", userService.getAll());
        return "create_rent";
    }

    @PostMapping("/create")
    public String create(@Validated @ModelAttribute Rent rent,
                         @RequestParam("bookId") int bookId,
                         @RequestParam("userId") int userId) {
        rent.setBook(bookService.readById(bookId));
        rent.setUser(userService.readById(userId));
        LocalDate localDate = LocalDate.now();
        LocalDate localDate2 = localDate.plusMonths(2);
        rent.setTimeTaken(java.sql.Date.valueOf(localDate));
        rent.setTimeShouldBeReturned(java.sql.Date.valueOf(localDate2));
        rentService.create(rent);
        return "redirect:/rent/all";
    }

    @GetMapping("/{id}/read")
    public String read(@PathVariable int id, Model model) {
        Rent rent = rentService.readById(id);
        model.addAttribute("rent", rent);
        return "rent_info";
    }

    @GetMapping("/all")
    public String getAll(Model model) {
        model.addAttribute("rents", rentService.getAll());
        return "rent_list";
    }

    @GetMapping("/{id}/return")
    public String update(@PathVariable int id, Model model) {
        Rent rent = rentService.readById(id);
        model.addAttribute("rent", rent);
        System.out.println(rent + "get method");
        return "update_rent";
    }



    @PostMapping("/{id}/return")
    public String update(@PathVariable(name = "id") int id) {
        Rent rent = rentService.readById(id);
        System.out.println(rent);
        java.util.Date utilDate = new java.util.Date();
        rent.setTimeReturned(new java.sql.Date(utilDate.getTime()));
        rentService.update(rent);
        return "redirect:/rent/all";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable("id") int id) {
        rentService.delete(id);
        return "redirect:/rent/all";
    }
}
