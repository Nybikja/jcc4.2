package com.company.jcc.service.impl;

import com.company.jcc.model.AuthorName;
import com.company.jcc.repository.AuthorNameRepository;
import com.company.jcc.service.AuthorNameService;

import java.util.List;

public class AuthorNameServiceImpl implements AuthorNameService {

    private AuthorNameRepository authorNameRepository;
    @Override
    public void create(AuthorName authorName) {
        authorNameRepository.create(authorName);
    }

    @Override
    public AuthorName readById(int id) {
        return authorNameRepository.readById(id);
    }

    @Override
    public AuthorName update(AuthorName authorName) {
        return authorNameRepository.update(authorName);
    }

    @Override
    public void delete(int id) {
        authorNameRepository.delete(id);
    }

    @Override
    public List<AuthorName> getAll() {
        return authorNameRepository.getAll();
    }
}
