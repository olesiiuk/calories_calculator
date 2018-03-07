package com.jay.calories_calculator.model.service.api;

import com.jay.calories_calculator.model.domain.User;

import java.util.List;

public interface UserService {

    User findUserByEmail(String email);

    void saveUser(User user);

    List<User> findAllUsers();

    User findUserById(Long id);

}
