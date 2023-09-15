package io.github.luis.store.services;

import io.github.luis.store.models.Role;

import java.util.List;

public interface RoleService {

    public List<Role> findAll();
    public Role create(Role role);
    public Boolean delete(Long id);

}
