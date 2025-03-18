package com.hostels.service;

import com.hostels.model.Room;
import com.hostels.repository.RoomRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;


@Service
public class RoomService {
    private RoomRepository roomRepository;

    public void delete(Long id) {
        Optional<Room> optionalRoom = roomRepository.findById(id);
        if (optionalRoom.isEmpty()) {
            throw new IllegalStateException("Room not found");
        }
        roomRepository.deleteById(id);
    }

    public List<Room> getAll() {
        return roomRepository.findAll();
    }

    public Room create(Room room) {
        Optional<Room> optionalRoom = roomRepository.findById(room.getId());
        if (optionalRoom.isPresent()) {
            throw new IllegalStateException("Room with id " + room.getId() + " already exists");
        }
        return roomRepository.save(room);
    }

    @Transactional
    public void update(Long id, Room room) {
        Optional<Room> optionalRoom = roomRepository.findById(id);
        if (optionalRoom.isEmpty()) {
            throw new IllegalStateException("Room with id " + room.getId() + " not found");
        }

        Room roomDb = optionalRoom.get();
        if (roomDb.isAvailability() != room.isAvailability()) {
            roomDb.setAvailability(room.isAvailability());
        }

        if (roomDb.getPrice() != room.getPrice()) {
            roomDb.setPrice(room.getPrice());
        }
    }
}
