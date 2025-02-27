package ru.hostels.Ident.model;

public class Review {
    private int id;
    private User user;
    private Hotel hotel;
    private double rating;
    private String comment;

    public Review(int id, User user, Hotel hotel, double rating, String comment) {
        this.id = id;
        this.user = user;
        this.hotel = hotel;
        this.rating = rating;
        this.comment = comment;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
