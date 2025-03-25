package com.hostels.service;

import com.hostels.dto.BookingCreateDto;
import com.hostels.dto.BookingDto;
import com.hostels.model.Booking;
import com.hostels.model.Room;
import com.hostels.model.User;
import com.hostels.repository.BookingRepository;
import com.hostels.repository.RoomRepository;
import com.hostels.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class BookingService {
    private final BookingRepository bookingRepository;
    private final UserRepository userRepository;
    private final RoomRepository roomRepository;

    public BookingService(BookingRepository bookingRepository,
                          UserRepository userRepository,
                          RoomRepository roomRepository) {
        this.bookingRepository = bookingRepository;
        this.userRepository = userRepository;
        this.roomRepository = roomRepository;
    }

    // Создание нового бронирования
    public BookingDto create(BookingCreateDto bookingDto) {
        User user = userRepository.findById(bookingDto.getUserId())
                .orElseThrow(() -> new IllegalStateException("User not found"));
        Room room = roomRepository.findById(bookingDto.getRoomId())
                .orElseThrow(() -> new IllegalStateException("Room not found"));

        Booking booking = bookingDto.toEntity();
        booking.setUser(user);
        booking.setRoom(room);
        bookingRepository.save(booking);

        return BookingDto.fromEntity(booking);
    }

    // Получение всех бронирований
    public List<BookingDto> findAll() {
        return bookingRepository.findAll().stream()
                .map(BookingDto::fromEntity)
                .collect(Collectors.toList());
    }

    // Получение бронирования по ID
    public Optional<BookingDto> findById(Long id) {
        return bookingRepository.findById(id)
                .map(BookingDto::fromEntity);
    }

    // Удаление бронирования
    public void delete(Long id) {
        if (!bookingRepository.existsById(id)) {
            throw new IllegalStateException("Booking not found");
        }
        bookingRepository.deleteById(id);
    }
}
