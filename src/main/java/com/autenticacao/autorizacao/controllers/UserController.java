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

import com.autenticacao.autorizacao.models.User;
import com.autenticacao.autorizacao.repositories.UserRepository;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserRepository repository;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/all")
    public List<User> getAll() {
        List<User> userList = repository.findAll();
        return userList;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/one/{id}")
    public Optional<User> getOne(@PathVariable("id") UUID id) {
        Optional<User> user = repository.findById(id);
        return user;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/save")
    public User save(@RequestBody User data) {
        User user = new User(data);
        repository.save(user);
        return user;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PatchMapping("/update/{id}")
    public Optional<User> update(@PathVariable("id") UUID id, @RequestBody User data) {
        Optional<User> findUser = repository.findById(id);
        if (findUser.isPresent()) {
            User user = findUser.get();
            if (data.getName() != null) {
                user.setName(data.getName());
            }
            if (data.getEmail() != null) {
                user.setEmail(data.getEmail());
            }
            if (data.getPassword() != null) {
                user.setPassword(data.getPassword());
            }
            repository.save(user);
        }
        return findUser;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @DeleteMapping("/delete/{id}")
    public Optional<User> delete(@PathVariable("id") UUID id) {
        Optional<User> findUser = repository.findById(id);
        if (findUser.isPresent()) {
            repository.deleteById(id);
        }

        return findUser;
    }
}