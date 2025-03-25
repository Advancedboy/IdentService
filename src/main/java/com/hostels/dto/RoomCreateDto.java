package com.hostels.dto;

import com.hostels.model.Room;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoomCreateDto {

    private Long hotelId;
    private String type;
    private double price;
    private boolean availability;

    // Метод для преобразования RoomCreateDto в сущность Room
    public Room toEntity() {
        Room room = new Room();
        room.setType(this.type);
        room.setPrice(this.price);
        room.setAvailability(this.availability);
        // hotelId будет установлен в сервисе при получении соответствующей сущности
        return room;
    }
}
