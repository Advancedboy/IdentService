package com.hostels.service;

import com.hostels.dto.RoomCreateDto;
import com.hostels.dto.RoomDto;
import com.hostels.model.Hotel;
import com.hostels.model.Room;
import com.hostels.repository.HotelRepository;
import com.hostels.repository.RoomRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class RoomService {

    private final RoomRepository roomRepository;
    private final HotelRepository hotelRepository;

    public RoomService(RoomRepository roomRepository, HotelRepository hotelRepository) {
        this.roomRepository = roomRepository;
        this.hotelRepository = hotelRepository;
    }

    // Получение всех комнат с использованием DTO
    public List<RoomDto> getAll() {
        List<Room> rooms = roomRepository.findAll();
        return rooms.stream()
                .map(RoomDto::fromEntity)  // Преобразуем Room в RoomDto
                .toList();
    }

    // Создание новой комнаты
    public RoomDto create(RoomCreateDto roomCreateDto) {
        // Проверяем наличие отеля
        Hotel hotel = hotelRepository.findById(roomCreateDto.getHotelId())
                .orElseThrow(() -> new IllegalStateException("Hotel not found"));

        // Создаем новую комнату
        Room room = roomCreateDto.toEntity();
        room.setHotel(hotel); // Устанавливаем связь с отелем

        // Сохраняем комнату
        Room savedRoom = roomRepository.save(room);

        // Возвращаем DTO
        return RoomDto.fromEntity(savedRoom);
    }

    // Обновление комнаты с использованием DTO
    @Transactional
    public RoomDto update(Long id, RoomDto roomDto) {
        Optional<Room> optionalRoom = roomRepository.findById(id);
        if (optionalRoom.isEmpty()) {
            throw new IllegalStateException("Room with id " + id + " not found");
        }

        Room roomDb = optionalRoom.get();

        // Обновление доступности
        if (roomDb.isAvailability() != roomDto.isAvailability()) {
            roomDb.setAvailability(roomDto.isAvailability());
        }

        // Обновление цены
        if (roomDb.getPrice() != roomDto.getPrice()) {
            roomDb.setPrice(roomDto.getPrice());
        }

        // Возвращаем обновленную комнату в виде DTO
        return RoomDto.fromEntity(roomDb);
    }

    // Удаление комнаты
    public void delete(Long id) {
        Optional<Room> optionalRoom = roomRepository.findById(id);
        if (optionalRoom.isEmpty()) {
            throw new IllegalStateException("Room not found");
        }
        roomRepository.deleteById(id);
    }
}
