package com.example.nuvalence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.nuvalence.domain.User;

public interface UserRepository extends JpaRepository<User, Integer> {

    boolean existsByUsername(String username);

    User findByUsername(String username);
}
