package com.hostels.dto;

import com.hostels.model.Hotel;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class HotelDto {
    private Long id;
    private String name;
    private String address;
    private String city;
    private String country;
    private String phone;
    private String description;
    private double capacity;
    private String amenities;
    private double stars;
    private Long ownerId;

    public static HotelDto fromEntity(Hotel hotel) {
        return new HotelDto(
                hotel.getId(),
                hotel.getName(),
                hotel.getAddress(),
                hotel.getCity(),
                hotel.getCountry(),
                hotel.getPhone(),
                hotel.getDescription(),
                hotel.getCapacity(),
                hotel.getAmenities(),
                hotel.getStars(),
                hotel.getOwner().getId()  // Получаем только ID владельца
        );
    }

    public static List<HotelDto> fromEntityList(List<Hotel> hotels) {
        return hotels.stream()
                .map(HotelDto::fromEntity)
                .collect(Collectors.toList());
    }
}
