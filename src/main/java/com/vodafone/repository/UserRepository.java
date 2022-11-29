package com.vodafone.repository;

import com.vodafone.model.User;

import java.util.List;

public interface UserRepository {

    void saveUser(User user);

    List<User> getAll();
}
