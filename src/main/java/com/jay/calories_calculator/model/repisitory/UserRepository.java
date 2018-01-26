package com.jay.calories_calculator.model.repisitory;

import com.jay.calories_calculator.model.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

}
