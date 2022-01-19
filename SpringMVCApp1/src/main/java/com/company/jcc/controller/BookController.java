package com.company.jcc.controller;

import com.company.jcc.model.Author;
import com.company.jcc.model.AuthorName;
import com.company.jcc.model.Book;
//import com.company.jcc.model.User;
import com.company.jcc.service.BookService;
import com.company.jcc.service.impl.AuthorNameServiceImpl;
import com.company.jcc.service.impl.AuthorServiceImpl;
import com.company.jcc.service.impl.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookServiceImpl bookService;

    @Autowired
    private AuthorServiceImpl authorService;

    @Autowired
    private AuthorNameServiceImpl authorNameService;

//    @GetMapping("/create")
//    public String create(Model model) {
//        model.addAttribute("book", new Book());
//        return "create_book";
//    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("authors", authorService.getAll());
        return "create_book2";
    }

    @PostMapping("/create")
    public String save(@Validated @ModelAttribute("book") Book book,
                         @RequestParam("authorId") int authorId){
        Book book1 = bookService.create(book);
        AuthorName authorName = new AuthorName();
        authorName.setBook(book1);
        authorName.setAuthor(authorService.readById(authorId));
        authorNameService.create(authorName);
        return "redirect:/books/all";
    }

//    @PostMapping("/create")
//    public String create(@Validated @ModelAttribute("book") Book book) {
//        bookService.create(book);
//        return "redirect:/books/all";
//    }

    @GetMapping("/{id}/read")
    public String read(@PathVariable int id, Model model) {
        model.addAttribute("book", bookService.readById(id));
        return "book_info";
    }

    @GetMapping("/all")
    public String getAll(Model model) {
        model.addAttribute("books", authorNameService.getAll());
        return "book_list2";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable("id") int id) {
        bookService.delete(id);
        return "redirect:/books/all";
    }

    @GetMapping("/{id}/update")
    public String update(@PathVariable("id") int id, Model model) {
        Book book = bookService.readById(id);
        model.addAttribute("book", book);
        System.out.println(book + "get method");
        return "update_book";
    }

    @PostMapping("/{id}/update")
    public String update(@PathVariable("id") int id, @RequestParam String bookTitle,
                         @RequestParam int amountLeft,
                         @RequestParam int amountGave,
                         @RequestParam int rating) {
        Book book = bookService.readById(id);
        System.out.println(book);
        book.setBookTitle(bookTitle);
        book.setAmountLeft(amountLeft);
        book.setAmountGave(amountGave);
        book.setRating(rating);
        if (book != null)
            bookService.update(book);
        return "redirect:/books/" + id + "/read";
    }

//    @GetMapping("/search")
//    public String search(@Validated @ModelAttribute("book") Book book){
//        return "book_search";
//    }
//
//    @GetMapping("/search/")
//    public String searchBookByTitle(@RequestParam String bookTitle, Model model){
//        model.addAttribute("book", bookService.readByTitle(bookTitle));
//        System.out.println(bookTitle);
//        return "book_info2";
//    }



    @GetMapping("/search")
    public String home(Book book, Model model, String bookTitle) {
        List<Book> books = bookService.getAll();
        if (bookTitle != null) {
            Book book2 = bookService.readByTitle(bookTitle);
            model.addAttribute("book", book2);
            return "index3";
        } else {
            model.addAttribute("books", books);
            return "index2";
        }
    }


    public BookController() {
    }

    public BookController(BookServiceImpl bookService, AuthorServiceImpl authorService, AuthorNameServiceImpl authorNameService) {
        this.bookService = bookService;
        this.authorService = authorService;
        this.authorNameService = authorNameService;
    }

    public AuthorNameServiceImpl getAuthorNameService() {
        return authorNameService;
    }

    public void setAuthorNameService(AuthorNameServiceImpl authorNameService) {
        this.authorNameService = authorNameService;
    }

    public BookService getBookService() {
        return bookService;
    }

    public void setBookService(BookServiceImpl bookService) {
        this.bookService = bookService;
    }

    public AuthorServiceImpl getAuthorService() {
        return authorService;
    }

    public void setAuthorService(AuthorServiceImpl authorService) {
        this.authorService = authorService;
    }
}