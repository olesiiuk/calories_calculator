package com.jay.calories_calculator.model.service;

import com.jay.calories_calculator.model.domain.Role;


public interface RoleService {
    Role findByRoleName(String roleName);
}
