package io.github.luis.store.services;

import io.github.luis.store.models.User;
import io.github.luis.store.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements  UserService{

    @Autowired
    private UserRepository repository;

    public  UserServiceImpl(UserRepository repository){
        this.repository = repository;
    }
    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public User create(User user) {
        return this.repository.save(user);

    }

    @Override
    public Boolean delete(Long id) {
        return null;
    }

    @Override
    public Boolean update(Long id, User user) {
        return null;
    }

}
