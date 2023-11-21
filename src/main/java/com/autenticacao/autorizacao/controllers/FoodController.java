package com.autenticacao.autorizacao.controllers;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.autenticacao.autorizacao.models.Food;
import com.autenticacao.autorizacao.repositories.FoodRepository;

@RestController
@RequestMapping("food")
public class FoodController {

    @Autowired
    private FoodRepository repository;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/all")
    public List<Food> getAll() {
        List<Food> foodList = repository.findAll();
        return foodList;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/one/{id}")
    public Optional<Food> getOne(@PathVariable("id") UUID id) {
        Optional<Food> food = repository.findById(id);
        return food;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/save")
    public Food save(@RequestBody Food data) {
        Food food = new Food(data);
        repository.save(food);
        return food;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PatchMapping("/update/{id}")
    public Optional<Food> update(@PathVariable("id") UUID id, @RequestBody Food data) {
        Optional<Food> findFood = repository.findById(id);
        if (findFood.isPresent()) {
            Food food = findFood.get();
            if (data.getTitle() != null) {
                food.setTitle(data.getTitle());
            }
            if (data.getImage() != null) {
                food.setImage(data.getImage());
            }
            if (data.getPrice() != null) {
                food.setPrice(data.getPrice());
            }
            repository.save(food);
        }
        return findFood;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @DeleteMapping("/delete/{id}")
    public Optional<Food> delete(@PathVariable("id") UUID id) {
        Optional<Food> findFood = repository.findById(id);
        if (findFood.isPresent()) {
            repository.deleteById(id);
        }

        return findFood;
    }
}