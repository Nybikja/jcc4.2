package com.company.jcc.service.impl;

import com.company.jcc.model.Request;
import com.company.jcc.repository.RequestRepository;
import com.company.jcc.service.RequestService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class RequestServiceImpl implements RequestService {
    private final RequestRepository requestRepository;

    public RequestServiceImpl(RequestRepository requestRepository) {
        this.requestRepository = requestRepository;
    }

    @Override
    public Request create(Request request) {
//        if (role != null) {
        return requestRepository.save(request);
//        }
    }

    @Override
    public Request readById(int id) {
        return requestRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Role with id " + id + " not found"));
    }

    @Override
    public Request update(Request request) {
//        if (role != null) {
        readById(request.getId());
        return requestRepository.save(request);
//        }
    }

    @Override
    public void delete(int id) {
        Request request = readById(id);
        requestRepository.delete(request);
    }

    @Override
    public List<Request> getAll() {
        return requestRepository.findAll();
    }
}
