package com.company.jcc.service.impl;

import com.company.jcc.model.Rent;
import com.company.jcc.model.Request;
import com.company.jcc.repository.RentRepository;
import com.company.jcc.service.RentService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class RentServiceImpl implements RentService {
    private final RentRepository rentRepository;

    public RentServiceImpl(RentRepository rentRepository) {
        this.rentRepository = rentRepository;
    }

    @Override
    public Rent create(Rent rent) {
        return rentRepository.create(rent);
    }

    @Override
    public Rent readById(int id) {
        return rentRepository.findById(id);
    }
    @Override
    public Rent update(Rent rent) {
        readById(rent.getId());
//        return rentRepository.update(rent);
        return null;
    }

    @Override
    public void delete(int id) {
        Rent rent = readById(id);
        rentRepository.delete(id);
    }

    @Override
    public List<Rent> getAll() {
        return rentRepository.findAll();
    }
}
