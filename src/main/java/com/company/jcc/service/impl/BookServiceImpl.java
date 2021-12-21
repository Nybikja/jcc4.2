package com.company.jcc.service.impl;

import com.company.jcc.model.Book;
import com.company.jcc.model.Rent;
import com.company.jcc.repository.BookRepository;
import com.company.jcc.service.BookService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book create(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book readById(int id) {
        return bookRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Book with id " + id + " not found"));
    }

    @Override
    public Book update(Book book) {
//        if (role != null) {
        readById(book.getId());
        return bookRepository.save(book);
//        }
    }

    @Override
    public void delete(int id) {
        Book book = readById(id);
        bookRepository.delete(book);
    }

    @Override
    public List<Book> getAll() {
        return bookRepository.findAll();
    }
}
