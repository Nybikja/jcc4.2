package com.company.jcc.controller;

import com.company.jcc.model.Book;
import com.company.jcc.model.User;
import com.company.jcc.service.BookService;
import com.company.jcc.service.impl.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookServiceImpl bookService;


    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("book", new Book());
        return "create_book";
    }

    @PostMapping("/create")
    public String create(@Validated @ModelAttribute("book") Book book) {
        bookService.create(book);
        return "redirect:/books/all";
    }

    @GetMapping("/all")
    public String getAll(Model model) {
        model.addAttribute("books", bookService.getAll());
        return "book_list";
    }

    public BookController() {
    }

    public BookService getBookService() {
        return bookService;
    }

    public void setBookService(BookServiceImpl bookService) {
        this.bookService = bookService;
    }
}