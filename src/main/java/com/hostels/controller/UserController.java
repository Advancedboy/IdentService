package com.hostels.controller;

import com.hostels.dto.UserCreateDto;
import com.hostels.dto.UserDto;
import com.hostels.model.User;
import com.hostels.service.UserService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;


@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public List<UserDto> findAll() {
        return userService.findAll().stream()
                .map(UserDto::fromEntity) // Конвертация в DTO
                .collect(Collectors.toList());
    }

    @GetMapping
    public ResponseEntity<UserDto> searchUser(@RequestParam String email) {
        return userService.getUserByEmail(email)
                .map(user -> ResponseEntity.ok(UserDto.fromEntity(user)))
                .orElseThrow(()
                        -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> findById(@PathVariable Long id) {
        return userService.findById(id)
                .map(user -> ResponseEntity.ok(UserDto.fromEntity(user)))
                .orElseThrow(()
                        -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
    }

    @PostMapping("/create")
    public ResponseEntity<UserDto> create(@RequestBody UserCreateDto userDto) {
        User user = userService.create(userDto.toEntity());
        return ResponseEntity.status(HttpStatus.CREATED).body(UserDto.fromEntity(user));
    }

    @PutMapping("/modify/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody UserCreateDto userDto) {
        userService.update(id, userDto.getName(), userDto.getEmail(), userDto.getPassword());
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
