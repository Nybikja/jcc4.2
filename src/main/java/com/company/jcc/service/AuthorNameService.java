package com.company.jcc.service;

import com.company.jcc.model.AuthorName;

import java.util.List;

public interface AuthorNameService {
    public void create(AuthorName authorName);
    public AuthorName readById(int id);
    public AuthorName update(AuthorName authorName);
    public void delete(int id);
    public List<AuthorName> getAll();
}
