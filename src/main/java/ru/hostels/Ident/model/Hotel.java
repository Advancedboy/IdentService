package ru.hostels.Ident.model;

public class Hotel {
    private int id;
    private String name;
    // TODO create location type
    private String location;
    private String description;
    private double capacity;
    private String amenities;
    private User owner;

    public Hotel(int id, String name, String location, String description, double capacity, String amenities, User owner) {
        // TODO checking input parameters
        this.id = id;
        this.name = name;
        this.location = location;
        this.description = description;
        this.capacity = capacity;
        this.amenities = amenities;
        this.owner = owner;
    }

    void addHotel(){}
    void updateHotel(){}
    void deleteHotel(){}

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    public String getAmenities() {
        return amenities;
    }

    public void setAmenities(String amenities) {
        this.amenities = amenities;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
}
