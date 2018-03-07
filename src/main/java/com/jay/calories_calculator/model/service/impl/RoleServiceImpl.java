package com.jay.calories_calculator.model.service.impl;

import com.jay.calories_calculator.model.domain.Role;
import com.jay.calories_calculator.model.repisitory.RoleRepository;
import com.jay.calories_calculator.model.service.api.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    private RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role findByRoleName(String roleName) {
        return roleRepository.findByRole(roleName);
    }

}
