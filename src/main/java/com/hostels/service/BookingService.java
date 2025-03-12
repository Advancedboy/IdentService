package com.hostels.service;

import com.hostels.enums.Role;
import com.hostels.model.Booking;
import com.hostels.model.Room;
import com.hostels.model.User;
import com.hostels.repository.BookingRepository;
import com.hostels.repository.RoomRepository;
import com.hostels.repository.UserRepository;
import java.time.LocalDate;


public class BookingService {
    private final BookingRepository bookingRepository;
    private final RoomRepository roomRepository;
    private final UserRepository userRepository;

    public BookingService(BookingRepository bookingRepository, RoomRepository roomRepository, UserRepository userRepository) {
        this.bookingRepository = bookingRepository;
        this.roomRepository = roomRepository;
        this.userRepository = userRepository;
    }

    public Booking createBooking(Long clientId, Long roomId, LocalDate checkIn, LocalDate checkOut){
        User client = userRepository.findById(clientId)
                .orElseThrow(() -> new RuntimeException("Client not found"));

        if (client.getRole() != Role.CLIENT){
            throw new RuntimeException("User is not a client");
        }

        Room room = roomRepository.findById(roomId)
                .orElseThrow(() -> new RuntimeException("Room not found"));

        Booking booking = new Booking();
        booking.setUser(client);
        booking.setRoom(room);
        booking.setCheckInDate(checkIn);
        booking.setCheckOutDate(checkOut);

        return bookingRepository.save(booking);
    }
}
