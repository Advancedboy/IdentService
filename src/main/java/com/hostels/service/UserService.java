package com.hostels.service;

import com.hostels.model.User;
import com.hostels.repository.UserRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserService {
    private final UserRepository userRepository;
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public Optional<User> findById(long id) {
        return userRepository.findById(id);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User create(User user) {
        Optional<User> optionalUser = userRepository.findByEmail(user.getEmail());
        if (optionalUser.isPresent()) {
            throw new IllegalStateException("User already exists");
        }
        user.setPassword(encoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public void delete(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isEmpty()) {
            throw new IllegalStateException("User not found");
        }
        userRepository.deleteById(id);
    }

    @Transactional
    public void update(Long id, String name, String email, String password) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isEmpty()) {
            throw new IllegalStateException("User with id " + id + "not found");
        }
        User user = optionalUser.get();

        if (email != null && !email.isBlank() && !email.equals(user.getEmail())) {
            if (userRepository.findByEmail(email).isPresent()) {
                throw new IllegalStateException("User with email " + email + " already exists");
            }
            user.setEmail(email);
        }


        if (name != null && !name.equals(user.getName())) {
            user.setName(name);
        }

        if (password != null && !encoder.matches(password, user.getPassword())) {
            user.setPassword(encoder.encode(password));
        }
    }
}
