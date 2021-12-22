package com.company.jcc.controller;

import com.company.jcc.model.Book;
import com.company.jcc.model.User;
import com.company.jcc.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/books")
public class BookController {

    private BookServiceImpl bookService;

//    @GetMapping("/create")
//    public String create(Book book) {
//        return "create_book";
//    }
//
//    @PostMapping("/create")
//    public String bookCreate (
//            @RequestParam String bookTitle,
//            @RequestParam int amountLeft,
//            @RequestParam int amountGave,
//            @RequestParam int rating
//    ) {
//        Book book = new Book(bookTitle, amountLeft, amountGave, rating);
//        bookService.create(new Book(bookTitle, amountLeft, amountGave, rating));
//        return "redirect:/books/" + book.getId() + "/read";
//    }

    @GetMapping("/create")
    public String create() {
        return "create_book";
    }


    @PostMapping("/create")
    public String create(@Validated @ModelAttribute("book") Book book) {
        bookService.create(book);
        return "redirect:/books/read";
    }

    @GetMapping("/all")
    public String getAll(Model model) {
        model.addAttribute("book", bookService.getAll());
        return "book_list";
    }

    public BookController() {
    }

    public BookServiceImpl getBookService() {
        return bookService;
    }

    public void setBookService(BookServiceImpl bookService) {
        this.bookService = bookService;
    }
}
