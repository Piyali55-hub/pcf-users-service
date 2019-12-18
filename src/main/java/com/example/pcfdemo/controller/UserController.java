package com.example.pcfdemo.controller;

import com.example.pcfdemo.model.User;
import com.example.pcfdemo.repository.UserRepo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.lang.String.format;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserRepo userRepo;

    public UserController(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @PostMapping
    public Long addUser(@RequestBody User user) {
        User savedUser = userRepo.save(user);
        return savedUser.getId();
    }

    @GetMapping("/id/{id}")
    public User getUser(@PathVariable Long id) {
        return userRepo.findById(id).orElseThrow(() -> new RuntimeException(format("user with %s not found", id)));
    }

    @PutMapping("/id/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user) {
        User updatedUser = User.builder().id(id).name(user.getName()).dob(user.getDob()).build();
        return userRepo.save(updatedUser);
    }

    @DeleteMapping("/id/{id}")
    public void deleteUser(@PathVariable Long id) {
        userRepo.deleteById(id);
    }
}
