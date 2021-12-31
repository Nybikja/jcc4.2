package com.company.jcc.service.impl;

import com.company.jcc.model.User;
import com.company.jcc.repository.UserRepository;
import com.company.jcc.service.UserService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User create(User user) {
        return userRepository.create(user);
    }

    @Override
    public User readById(int id) {
        return userRepository.readById(id);
    }

    @Override
    public User update(User user) {
            return userRepository.update(user);
    }

    @Override
    public void delete(int id) {
        userRepository.delete(id);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }
}
