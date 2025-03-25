package com.hostels.dto;

import com.hostels.model.Room;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoomDto {

    private Long id;
    private Long hotelId;
    private String type;
    private double price;
    private boolean availability;
    private List<Long> bookedUserIds;

    public static RoomDto fromEntity(Room room) {
        return new RoomDto(
                room.getId(),
                room.getHotel().getId(),
                room.getType(),
                room.getPrice(),
                room.isAvailability(),
                room.getUsers().stream()
                        .map(user -> user.getId())  // Получаем только ID пользователей
                        .collect(Collectors.toList())
        );
    }
}
