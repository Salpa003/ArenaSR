package com.example.arenasr.repository;

import com.example.arenasr.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsUserByUsername(String username);
}
