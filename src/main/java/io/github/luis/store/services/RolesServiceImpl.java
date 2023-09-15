package io.github.luis.store.services;

import io.github.luis.store.models.Role;
import io.github.luis.store.repositories.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolesServiceImpl implements RoleService{

    @Autowired
    private RolesRepository repository;

    public RolesServiceImpl(RolesRepository repository){
        this.repository =repository;
    }
    @Override
    public List<Role> findAll() {
        return null;
    }

    @Override
    public Role create(Role role) {
        role.setName(role.getName().toUpperCase());
        Role roleCreated =  this.repository.save(role);
        return  roleCreated;
    }

    @Override
    public Boolean delete(Long id) {
        return null;
    }
}
