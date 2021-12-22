package com.company.jcc.repository;

import com.company.jcc.model.Book;
import com.company.jcc.service.BookService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookRepository implements BookService {
    @Override
    public Book create(Book book) {
        return null;
    }

    @Override
    public Book readById(int id) {
        return null;
    }

    @Override
    public Book update(Book book) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<Book> getAll() {
        return null;
    }
}
