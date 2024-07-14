package com.isil.demo.jwt.repository;

import com.isil.demo.jwt.model.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalRepository extends JpaRepository<Animal,Long> {
}
