package com.jay.calories_calculator.model.service;

import com.jay.calories_calculator.model.domain.User;

public interface UserService {

    User findUserByEmail(String email);

    void saveUser(User user);

}
