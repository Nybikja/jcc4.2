//package com.company.jcc.service.impl;
//
//import com.company.jcc.model.Rent;
//import com.company.jcc.model.Request;
//import com.company.jcc.repository.RentRepository;
//import com.company.jcc.service.RentService;
//import org.springframework.stereotype.Service;
//
//import javax.persistence.EntityNotFoundException;
//import java.util.List;
//
//@Service
//public class RentServiceImpl implements RentService {
//    private final RentRepository rentRepository;
//
//    public RentServiceImpl(RentRepository rentRepository) {
//        this.rentRepository = rentRepository;
//    }
//
//    @Override
//    public Rent create(Rent rent) {
//        return rentRepository.save(rent);
//    }
//
//    @Override
//    public Rent readById(int id) {
//        return rentRepository.findById(id).orElseThrow(
//                () -> new EntityNotFoundException("Rent with id " + id + " not found"));
//    }
//
//    @Override
//    public Rent update(Rent rent) {
////        if (role != null) {
//        readById(rent.getId());
//        return rentRepository.save(rent);
////        }
//    }
//
//    @Override
//    public void delete(int id) {
//        Rent rent = readById(id);
//        rentRepository.delete(rent);
//    }
//
//    @Override
//    public List<Rent> getAll() {
//        return rentRepository.findAll();
//    }
//}
