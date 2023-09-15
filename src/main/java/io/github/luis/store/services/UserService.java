package io.github.luis.store.services;

import io.github.luis.store.models.User;

import java.util.List;

public interface UserService {
    public List<User> findAll();
    public User create(User user);
    public Boolean delete(Long id);
    public  Boolean update(Long id, User user);
}
