package com.hostels.controller;

import com.hostels.model.Booking;
import com.hostels.service.BookingService;
import com.hostels.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/bookings")
public class BookingController {
    private final BookingService bookingService;
    private final UserService userService;

    public BookingController(BookingService bookingService, UserService userService) {
        this.bookingService = bookingService;
        this.userService = userService;
    }

    @GetMapping(path = "/data/all")
    public List<Booking> getAllBookings() {
        return bookingService.findAll();
    }

    @GetMapping(path = "/data/{id}")
    public Optional<Booking> getBookingById(@PathVariable Long id) {
        return bookingService.findById(id);
    }

    @PostMapping(path = "/create")
    public Booking create(@RequestBody Booking booking) {
        if (booking.getUser() == null || booking.getRoom() == null) {
            throw new IllegalArgumentException("User and Room must be provided");
        }
        return bookingService.createBooking(
                booking.getUser().getId(),
                booking.getRoom().getId(),
                booking.getCheckInDate(),
                booking.getCheckOutDate(),
                booking.getTotalPrice()
        );
    }

    @PutMapping(path = "/modify/{id}")
    public void update(@PathVariable Long id, @RequestBody Booking booking) {
        if (booking.getCheckInDate() == null || booking.getCheckOutDate() == null) {
            throw new IllegalArgumentException("Check-in and Check-out dates must be provided");
        }
        bookingService.update(id, booking.getCheckInDate(), booking.getCheckOutDate());
    }


    @DeleteMapping
    public void delete(@PathVariable Long id) {
        bookingService.delete(id);
    }
}
