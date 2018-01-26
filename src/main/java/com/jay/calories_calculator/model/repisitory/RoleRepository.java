package com.jay.calories_calculator.model.repisitory;

import com.jay.calories_calculator.model.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByRole(String role);

}

