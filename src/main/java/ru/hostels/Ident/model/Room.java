package ru.hostels.Ident.model;

public class Room {
    private int id;
    private Hotel hotel;
    // TODO create room_type enum
    private String type;
    private double price;
    private boolean availability;

    public Room(int id, Hotel hotel, String type, double price, boolean availability) {
        this.id = id;
        this.hotel = hotel;
        this.type = type;
        this.price = price;
        this.availability = availability;
    }

    void addRoom(){}

    void updateRoom(){}

    void checkAvailability(){}

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }


}
