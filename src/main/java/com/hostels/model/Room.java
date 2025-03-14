package com.hostels.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import org.springframework.data.annotation.Id;

@Entity
@Table(name = "rooms")
public class Room {
    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy  =  GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "hotel_id", nullable = false)
    private Hotel hotel;
    // TODO create room_type enum
    private String type;
    private double price;
    private boolean availability;

    @ManyToMany(mappedBy  =  "bookedRooms")
    private final List<User> users =  new ArrayList<>();

    public Room(Long id, Hotel hotel, String type, double price, boolean availability) {
        this.id  =  id;
        this.hotel  =  hotel;
        this.type  =  type;
        this.price  =  price;
        this.availability  =  availability;
    }

    public Room() {}

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id  =  id;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel  =  hotel;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type  =  type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price  =  price;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability  =  availability;
    }
}
