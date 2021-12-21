package com.company.jcc.service.impl;

import com.company.jcc.model.Book;
import com.company.jcc.model.Rent;
import com.company.jcc.repository.BookRepository;
import com.company.jcc.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.persistence.TypedQuery;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

//    public void create(String bookTitle, int amountLeft, int amountGave, int rating){
//        bookRepository.create(new Book(bookTitle, amountLeft, amountGave, rating));
//    }

    @Override
    public List<Book> getAll() {
        return bookRepository.getAll();
    }

    @Override
    public void create(Book book) {
        bookRepository.create(book);
    }


//    @Override
//    public Book readById(int id) {
//        return bookRepository.findById(id).orElseThrow(
//                () -> new EntityNotFoundException("Book with id " + id + " not found"));
//    }
//
//    @Override
//    public Book update(Book book) {
////        if (role != null) {
//        readById(book.getId());
//        return bookRepository.save(book);
////        }
//    }
//
//    @Override
//    public void delete(int id) {
//        Book book = readById(id);
//        bookRepository.delete(book);
//    }
//
//    @Override
//    public List<Book> getAll() {
//        return bookRepository.findAll();
//    }
}
