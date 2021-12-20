package com.company.jcc.service.impl;

import com.company.jcc.model.Role;
import com.company.jcc.repository.RoleRepository;
import com.company.jcc.service.RoleService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role create(Role role) {
//        if (role != null) {
            return roleRepository.save(role);
//        }
    }

    @Override
    public Role readById(int id) {
        return roleRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Role with id " + id + " not found"));
    }

    @Override
    public Role update(Role role) {
//        if (role != null) {
            readById(role.getId());
            return roleRepository.save(role);
//        }
    }

    @Override
    public void delete(int id) {
        Role role = readById(id);
        roleRepository.delete(role);
    }

    @Override
    public List<Role> getAll() {
        return roleRepository.findAll();
    }
}
