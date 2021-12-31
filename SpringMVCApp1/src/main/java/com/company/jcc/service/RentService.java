package com.company.jcc.service;

import com.company.jcc.model.Rent;

import java.util.List;

public interface RentService {
    Rent create(Rent rent);
    Rent readById(int id);
    Rent update(Rent rent);
    void delete(int id);
    List<Rent> getAll();
}
