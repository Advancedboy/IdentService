package com.hostels.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hostels.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
