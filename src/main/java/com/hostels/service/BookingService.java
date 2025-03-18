package com.hostels.service;

import com.hostels.enums.Role;
import com.hostels.exception.NotFoundException;
import com.hostels.exception.UnauthorizedActionException;
import com.hostels.model.Booking;
import com.hostels.model.Room;
import com.hostels.model.User;
import com.hostels.repository.BookingRepository;
import com.hostels.repository.RoomRepository;
import com.hostels.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {
    private final BookingRepository bookingRepository;
    private final RoomRepository roomRepository;
    private final UserRepository userRepository;

    public boolean isRoomAvailable(Long roomId, LocalDate checkIn, LocalDate checkOut, Long bookingId) {
        Room room = roomRepository.findById(roomId)
                .orElseThrow(() -> new NotFoundException("Room not found"));
        return !bookingRepository.existsByRoomAndCheckInDateBeforeAndCheckOutDateAfterAndIdNot(
                room, checkOut, checkIn, bookingId
        );
    }

    public BookingService(BookingRepository bookingRepository,
                          RoomRepository roomRepository,
                          UserRepository userRepository) {
        this.bookingRepository = bookingRepository;
        this.roomRepository = roomRepository;
        this.userRepository = userRepository;
    }

    public Booking createBooking(Long clientId,
                                 Long roomId,
                                 LocalDate checkIn,
                                 LocalDate checkOut,
                                 double totalPrice) {
        User client = userRepository.findById(clientId)
                .orElseThrow(() -> new NotFoundException("Client not found"));

        if (client.getRole() != Role.CLIENT) {
            throw new UnauthorizedActionException("User is not a client");
        }

        Room room = roomRepository.findById(roomId)
                .orElseThrow(() -> new NotFoundException("Room not found"));

        Booking booking = new Booking();
        booking.setUser(client);
        booking.setRoom(room);
        booking.setCheckInDate(checkIn);
        booking.setCheckOutDate(checkOut);
        booking.setTotalPrice(totalPrice);

        return bookingRepository.save(booking);
    }

    public List<Booking> findAll() {
        return bookingRepository.findAll();
    }

    public Optional<Booking> findById(Long id) {
        return bookingRepository.findById(id);
    }

    @Transactional
    public void update(Long id, LocalDate checkInDate, LocalDate checkOutDate) {
        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Booking not found"));

        if (checkOutDate.isBefore(checkInDate) || checkOutDate.isEqual(checkInDate)) {
            throw new IllegalArgumentException("Check-out date must be after check-in date");
        }

        boolean isRoomAvailable = isRoomAvailable(
                booking.getRoom().getId(), checkOutDate, checkInDate, id);

        if (isRoomAvailable) {
            throw new IllegalStateException("Room is already booked for these dates");
        }

        booking.setCheckInDate(checkInDate);
        booking.setCheckOutDate(checkOutDate);
    }

    public void delete(Long id) {
        Optional<Booking> optionalBooking = bookingRepository.findById(id);
        if (optionalBooking.isEmpty()) {
            throw new IllegalStateException("Booking not found");
        }
        bookingRepository.deleteById(id);
    }
}
