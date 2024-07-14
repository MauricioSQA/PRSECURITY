package com.isil.demo.jwt.services;

import com.isil.demo.jwt.model.Animal;

import java.util.List;

public interface IAnimalService {

    Animal save(Animal animal);

    List<Animal> findAll();

    Animal findById(Long id);

    Animal updateAnimal(Animal animal);

    void deleteById(Long id);
}
