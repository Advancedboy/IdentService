package com.hostels.controller;

import com.hostels.model.User;
import com.hostels.service.UserService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "item")
    public List<User> findAll() {
        // return userService.findAll();
        return List.of(
                new User(1, "Pawel", "haidukevich@gmail.com", "password", Role.OWNER),
                new User(2, "Andrew", "drew@gmail.com", "dawdawdaw", Role.CLIENT),
                new User(3, "Alexey", "kevichlexa@gmail.com", "lesha228", Role.OWNER)
        );
    }

    @PostMapping
    public User create(@RequestBody User user) {
        return userService.create(user);
    }
}
