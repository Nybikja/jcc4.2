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
    public User create(User role) {
//        if (role != null) {
            return userRepository.save(role);
//        }
//        throw new NullEntityReferenceException("User cannot be 'null'");
    }

    @Override
    public User readById(int id) {
        return userRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("User with id " + id + " not found"));
    }

    @Override
    public User update(User role) {
//        if (role != null) {
            readById(role.getId());
            return userRepository.save(role);
//        }
//        throw new NullEntityReferenceException("User cannot be 'null'");
    }

    @Override
    public void delete(int id) {
        User user = readById(id);
        userRepository.delete(user);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user = userRepository.findByEmail(username);
//        if (user == null) {
//            throw new UsernameNotFoundException("User not Found!");
//        }
//        return user;
//    }
}
