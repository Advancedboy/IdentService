package com.hostels.controller;

import com.hostels.model.User;
import com.hostels.service.UserService;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/data/all")
    public List<User> findAll() {
        return userService.findAll();
    }

    @GetMapping("/data/email/{email}")
    public Optional<User> getUserByEmail(@PathVariable String email) {
        return userService.getUserByEmail(email);
    }

    @GetMapping(path = "/data/{id}")
    public Optional<User> findById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @PostMapping(path = "/create")
    public User create(@RequestBody User user) {
        return userService.create(user);
    }

    @PutMapping(path = "/modify/{id}")
    public void update(@PathVariable Long id, @RequestBody User user) {
        userService.update(id, user.getName(), user.getEmail(), user.getPassword());
    }

    @DeleteMapping(path = "/delete/{id}")
    public void delete(@PathVariable(name="id") Long id) {
        userService.delete(id);
    }
}
