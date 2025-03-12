package com.hostels.service;

import com.hostels.model.Hotel;
import com.hostels.model.User;
import com.hostels.repository.HotelRepository;
import com.hostels.repository.UserRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class HotelService {
    private final HotelRepository hotelRepository;
    private final UserRepository userRepository;

    public HotelService(HotelRepository hotelRepository, UserRepository userRepository) {
        this.hotelRepository = hotelRepository;
        this.userRepository = userRepository;
    }

    public Hotel createHotel(Hotel hotel, Long ownerId) {
        User owner = userRepository.findById(ownerId)
                .orElseThrow(() -> new RuntimeException("Owner not found"));

        hotel.setOwner(owner);
        return hotelRepository.save(hotel);
    }

    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    public Hotel updateHotel(Long hotelId, Hotel hotelDetails) {
        Hotel hotel = hotelRepository.findById(hotelId)
                .orElseThrow(() -> new RuntimeException("Hotel not found"));

        hotel.setName(hotelDetails.getName());
        hotel.setAddress(hotelDetails.getName());
        hotel.setCity(hotelDetails.getCity());
        hotel.setCountry(hotelDetails.getCountry());
        hotel.setPhone(hotelDetails.getPhone());
        hotel.setStars(hotel.getStars());

        return hotelRepository.save(hotel);
    }

    public void deleteHotel(Long hotelId) {
        Hotel hotel = hotelRepository.findById(hotelId)
                .orElseThrow(() -> new RuntimeException("Hotel not found"));

        hotelRepository.delete(hotel);
    }

    public List<Hotel> getHotelsByOwner(Long ownerId) {
        return hotelRepository.findByOwnerId(ownerId);
    }
}