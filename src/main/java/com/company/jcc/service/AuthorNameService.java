package com.company.jcc.service;

import com.company.jcc.model.AuthorName;

import java.util.List;

public interface AuthorNameService {
    AuthorName create(AuthorName authorName);
    AuthorName readById(int id);
    AuthorName update(AuthorName authorName);
    void delete(int id);
    List<AuthorName> getAll();
}
