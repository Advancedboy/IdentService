package com.hostels.dto;

import com.hostels.model.Hotel;
import com.hostels.model.User;
import lombok.Data;

@Data
public class HotelCreateDto {
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

    public Hotel toEntity() {
        Hotel hotel = new Hotel();
        hotel.setName(this.name);
        hotel.setAddress(this.address);
        hotel.setCity(this.city);
        hotel.setCountry(this.country);
        hotel.setPhone(this.phone);
        hotel.setDescription(this.description);
        hotel.setCapacity(this.capacity);
        hotel.setAmenities(this.amenities);
        hotel.setStars(this.stars);
        hotel.setOwner(new User(ownerId));
        return hotel;
    }
}
