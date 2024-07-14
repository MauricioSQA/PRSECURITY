package com.isil.demo.jwt.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.isil.demo.jwt.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{
		Optional<User> findByUsername(String username);
}
