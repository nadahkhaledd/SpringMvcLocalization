package com.vodafone.service;

import com.vodafone.model.User;
import com.vodafone.repository.UserRepository;
import com.vodafone.repository.UserRepositoryImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    //List<User> users = new ArrayList<>();

    private final UserRepository repository;

    @Autowired
    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }


    @Override
    public User save(User user) {
        repository.saveUser(user);
        return user;
    }

    @Override
    public List<User> findAll() {
        return repository.getAll();
    }
}
