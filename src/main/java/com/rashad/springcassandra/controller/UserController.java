package com.rashad.springcassandra.controller;

import com.rashad.springcassandra.model.User;
import com.rashad.springcassandra.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserRepository repository;

    @PostConstruct
    public void saveUser() {
        List<User> users = new ArrayList<>();
        users.add(new User(6437, "Rashad", "Baku", 26));
        users.add(new User(3523, "Parvin", "Baku", 20));
        users.add(new User(8694, "Rauf", "Baku", 30));
        users.add(new User(9854, "Murad", "Baku", 25));
        repository.saveAll(users);
    }

    @GetMapping("/getAllUsers")
    public List<User> getUsers() {
        return repository.findAll();
    }

    @GetMapping("/getUserFilterByAge/{age}")
    public List<User> getUserFilterByAge(@PathVariable int age) {
        return repository.findByAgeGreaterThan(age);
    }
}
