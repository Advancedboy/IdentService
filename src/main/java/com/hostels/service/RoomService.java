package com.hostels.service;

import com.hostels.model.Room;
import com.hostels.repository.RoomRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomService {

    @Autowired
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
        if(optionalRoom.isPresent()) {
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

        Room room_ = optionalRoom.get();
        if (room_.isAvailability() != room.isAvailability()) {
            room_.setAvailability(room.isAvailability());
        }

        if(room_.getPrice() != room.getPrice()) {
            room_.setPrice(room.getPrice());
        }
    }
}
