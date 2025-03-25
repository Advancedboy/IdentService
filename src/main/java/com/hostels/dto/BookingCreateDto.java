package com.hostels.dto;

import com.hostels.model.Booking;
import com.hostels.model.Room;
import com.hostels.model.User;
import java.time.LocalDate;
import lombok.Data;

@Data
public class BookingCreateDto {
    private Long userId;
    private Long roomId;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private double totalPrice;

    // Преобразуем DTO в сущность
    public Booking toEntity() {
        Booking booking = new Booking();
        booking.setUser(new User(userId)); // создаем пользователя по ID
        booking.setRoom(new Room(roomId)); // создаем комнату по ID
        booking.setCheckInDate(checkInDate);
        booking.setCheckOutDate(checkOutDate);
        booking.setTotalPrice(totalPrice);
        booking.setStatus(false); // статус по умолчанию false
        return booking;
    }
}
