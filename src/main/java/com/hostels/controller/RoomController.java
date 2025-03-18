package com.hostels.controller;

import com.hostels.model.Room;
import com.hostels.service.RoomService;
import com.hostels.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/rooms")
public class RoomController {
    private final RoomService roomService;

    public RoomController(RoomService roomService, UserService userService) {
        this.roomService = roomService;
    }

    @GetMapping(path = "/data/all")
    public List<Room> getAll() {
        return roomService.getAll();
    }

    @PostMapping(path = "/create")
    public Room create(@RequestBody Room room) {return roomService.create(room);}

    @PutMapping(path = "/modify/{id}")
    public void update(@PathVariable Long id, @RequestBody Room room) {
        roomService.update(id, room);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void delete(@PathVariable(name = "id") Long id) {
        roomService.delete(id);
    }
}
