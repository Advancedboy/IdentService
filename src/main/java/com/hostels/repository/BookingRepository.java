package com.hostels.repository;

import com.hostels.model.Booking;
import com.hostels.model.Room;
import java.time.LocalDate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    boolean existsByRoomAndCheckInDateBeforeAndCheckOutDateAfterAndIdNot(Room room,
                                                                         LocalDate checkOut,
                                                                         LocalDate checkIn,
                                                                         Long bookingId);
}
