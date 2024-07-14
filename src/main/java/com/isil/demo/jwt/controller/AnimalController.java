package com.isil.demo.jwt.controller;


import com.isil.demo.jwt.model.Animal;
import com.isil.demo.jwt.services.IAnimalService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/animales")
@AllArgsConstructor
public class AnimalController {

    @Autowired
    private IAnimalService service;


    @GetMapping
    public List<Animal> findAll(){return service.findAll();}

    @GetMapping("/{id}")
    public Animal fidById(@PathVariable("id")Long id){return service.findById(id);}

    @PostMapping
    public Animal save(@RequestBody Animal animal) {
        return service.save(animal);
    }

    @PutMapping
    public Animal update(@RequestBody Animal animal) {
        return service.save(animal);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        service.deleteById(id);
    }




}
