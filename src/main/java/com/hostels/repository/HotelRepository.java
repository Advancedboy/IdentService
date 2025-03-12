package com.hostels.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hostels.model.Hotel;

import java.util.List;

public interface HotelRepository extends JpaRepository<Hotel, Long> {
    List<Hotel> findByOwnerId(Long ownerId);
}
