package com.hostels.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hostels.model.Room;

public interface RoomRepository extends JpaRepository<Room, Long> {
}
