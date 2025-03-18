package com.hostels.controller;

import com.hostels.model.Room;
import com.hostels.service.RoomService;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "/api/rooms")
public class RoomController {
    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping(path = "/data/all")
    public List<Room> getAll() {
        return roomService.getAll();
    }

    @PostMapping(path = "/create")
    public Room create(@RequestBody Room room) {
        return roomService.create(room);
    }

    @PutMapping(path = "/modify/{id}")
    public void update(@PathVariable Long id, @RequestBody Room room) {
        roomService.update(id, room);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void delete(@PathVariable(name = "id") Long id) {
        roomService.delete(id);
    }
}
