package com.company.jcc.controller;

import com.company.jcc.model.Author;
import com.company.jcc.model.AuthorName;
import com.company.jcc.model.Book;
import com.company.jcc.service.BookService;
import com.company.jcc.service.impl.AuthorNameServiceImpl;
import com.company.jcc.service.impl.AuthorServiceImpl;
import com.company.jcc.service.impl.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        model.addAttribute("book", authorNameService.readById(id));
        //model.addAttribute("book", bookService.readById(id));
        return "book_info2";
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
        model.addAttribute("authors", authorService.getAll());
        return "update_book";
    }


    @PostMapping("/{id}/update")
    public String update(@PathVariable("id") int id, @RequestParam String bookTitle,
                         @RequestParam int amountLeft,
                         @RequestParam int amountGave,
                         @RequestParam int rating,
                         @RequestParam("authorId") int authorId){
        Book book = bookService.readById(id);
        book.setBookTitle(bookTitle);
        book.setAmountLeft(amountLeft);
        book.setAmountGave(amountGave);
        book.setRating(rating);
        AuthorName authorName = authorNameService.readById(id);
        authorName.setAuthor(authorService.readById(authorId));
        bookService.update(book);
        authorNameService.update(authorName);
        return "redirect:/books/all";
    }

//    @GetMapping("/search/byauthor")
//    public String search(Model model){
//    List<AuthorName> authorNames = authorNameService.getAll();
//    model.addAttribute("books", authorNames);
//    return "index4";
//    }
//
//    @PostMapping("/search/byauthor")
//    public String searchBookByTitle(@RequestParam String author, Model model){
//        model.addAttribute("book", authorNameService.readByAuthor(author));
//        System.out.println(author);
//        return "index5";
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

    @GetMapping("/search/byauthor")
    public String search(Author author2, Model model, String author) {
        List<AuthorName> authorNames = authorNameService.getAll();
        if (author != null) {
            authorNames = authorNameService.readByAuthor(author);
        }
        model.addAttribute("books", authorNames);
        return "index4";
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