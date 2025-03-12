package com.hostels.repository;

import com.hostels.model.Hotel;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel, Long> {
    List<Hotel> findByOwnerId(Long ownerId);
}
