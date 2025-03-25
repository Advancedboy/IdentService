package com.hostels.dto;

import com.hostels.model.Booking;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class BookingDto {
    private Long id;
    private Long userId;
    private Long roomId;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private double totalPrice;
    private boolean status;

    public static BookingDto fromEntity(Booking booking) {
        return new BookingDto(
                booking.getId(),
                booking.getUser().getId(), // передаем только ID пользователя
                booking.getRoom().getId(), // передаем только ID комнаты
                booking.getCheckInDate(),
                booking.getCheckOutDate(),
                booking.getTotalPrice(),
                booking.isStatus()
        );
    }
}

