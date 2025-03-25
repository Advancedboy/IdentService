package com.hostels.controller;

import com.hostels.dto.RoomCreateDto;
import com.hostels.dto.RoomDto;
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

    // Получение всех комнат
    @GetMapping(path = "/data/all")
    public List<RoomDto> getAll() {
        return roomService.getAll();
    }

    // Создание новой комнаты
    @PostMapping(path = "/create")
    public RoomDto create(@RequestBody RoomCreateDto roomCreateDto) {
        return roomService.create(roomCreateDto);
    }

    // Обновление комнаты
    @PutMapping(path = "/modify/{id}")
    public RoomDto update(@PathVariable Long id, @RequestBody RoomDto roomDto) {
        return roomService.update(id, roomDto);
    }

    // Удаление комнаты
    @DeleteMapping(path = "/delete/{id}")
    public void delete(@PathVariable(name = "id") Long id) {
        roomService.delete(id);
    }
}
