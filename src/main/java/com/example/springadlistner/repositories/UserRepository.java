package com.example.springadlistner.repositories;

import com.example.springadlistner.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findById(long id);

}
