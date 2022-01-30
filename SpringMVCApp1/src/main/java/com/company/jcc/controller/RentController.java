package com.company.jcc.controller;

import com.company.jcc.model.Book;
import com.company.jcc.model.Rent;
import com.company.jcc.model.User;

import com.company.jcc.service.impl.BookServiceImpl;
import com.company.jcc.service.impl.RentServiceImpl;
import com.company.jcc.service.impl.UserServiceImpl;
import org.joda.time.DateTime;
import org.springframework.beans.PropertyAccessException;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DefaultBindingErrorProcessor;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

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
        Book book = bookService.readById(bookId);
        bookService.rentBook(bookId);
        rent.setBook(book);
        rent.setUser(userService.readById(userId));
        LocalDate localDate = LocalDate.now();
        LocalDate localDate2 = localDate.plusMonths(2);
        rent.setTimeTaken(localDate);
        rent.setTimeShouldBeReturned(localDate2);
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
//        java.util.Date utilDate = new java.util.Date();
        LocalDate date = LocalDate.now();
        rent.setTimeReturned(date);
        rentService.update(rent);
        return "redirect:/rent/all";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable("id") int id) {
        rentService.delete(id);
        return "redirect:/rent/all";
    }

    @GetMapping("/statistic")
    public String statistic(){
//        model.addAttribute("rents", rentService.getAll());
        return "book_statistic";
    }


    @PostMapping("/statistic")
    public String statistic(@RequestParam("dateStart") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateStart,
                            @RequestParam("dateEnd") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateEnd,
                            Model model){
        model.addAttribute("dateStart", dateStart);
        model.addAttribute("dateEnd", dateEnd);
        Rent mostPopular = rentService.getMostPopular(dateStart, dateEnd);
        Rent mostUnpopular = rentService.getMostUnpopular(dateStart, dateEnd);
        model.addAttribute("rent", mostPopular);
        model.addAttribute("rent2", mostUnpopular);
        return "rent_list2";
    }

    @GetMapping("/debtors")
    public String notReturned(Model model){
        model.addAttribute("users", rentService.findUsersNotReturnedInTime());
        return "debtors";
    }

    @GetMapping("/count")
    public String count(){
        return "book_statistic2";
    }

    @PostMapping("/count")
    public String count(@RequestParam("dateStart") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateStart,
                        @RequestParam("dateEnd") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateEnd,
                        Model model){
        model.addAttribute("dateStart", dateStart);
        model.addAttribute("dateEnd", dateEnd);
        int count = rentService.howManyBook(dateStart, dateEnd);
        model.addAttribute("count", count);
        return "rent_list3";
    }
}
