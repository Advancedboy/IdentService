package com.hostels.repository;

import com.hostels.model.Booking;
import com.hostels.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    boolean existsByRoomAndCheckInDateBeforeAndCheckOutDateAfterAndIdNot(Room room, LocalDate checkOut, LocalDate checkIn, Long bookingId);
}
