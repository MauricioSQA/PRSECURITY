package com.isil.demo.jwt.services.implementation;


import com.isil.demo.jwt.model.Animal;
import com.isil.demo.jwt.repository.AnimalRepository;
import com.isil.demo.jwt.services.IAnimalService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AnimalServiceImpl implements IAnimalService {

    @Autowired
    private AnimalRepository animalRepository;


    @Override
    public Animal save(Animal animal) {
        return animalRepository.save(animal);
    }

    @Override
    public List<Animal> findAll() {
        return animalRepository.findAll();
    }

    @Override
    public Animal findById(Long id) {
        return animalRepository.findById(id).get();
    }

    @Override
    public Animal updateAnimal(Animal animal) {
        Animal existingAnimal = animalRepository.findById(animal.getId()).get();
        existingAnimal.setNombre(animal.getNombre());
        existingAnimal.setNombrecient(animal.getNombrecient());
        return animalRepository.save(existingAnimal);
    }

    @Override
    public void deleteById(Long id) {
            animalRepository.deleteById(id);
    }
}
