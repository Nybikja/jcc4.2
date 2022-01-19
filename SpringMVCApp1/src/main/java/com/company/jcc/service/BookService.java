package com.company.jcc.service;

import com.company.jcc.model.Book;


import java.util.List;

public interface BookService {

    List<Book> getAll();
    Book create(Book book);
    Book readById(int id);
    Book readByTitle(String title);
    Book update(Book book);
    void delete(int id);
}
