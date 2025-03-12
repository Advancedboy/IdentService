package com.hostels.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name  =  "reviews")
public class Review {
    @Id
    @GeneratedValue(strategy  =  GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name  =  "user_id", nullable  =  false)
    private User user;

    @ManyToOne
    @JoinColumn(name  =  "hotel_id", nullable = false)
    private Hotel hotel;

    private double rating;
    private String comment;

    public Review(Long id, User user, Hotel hotel, double rating, String comment) {
        this.id  =  id;
        this.user  =  user;
        this.hotel  =  hotel;
        this.rating  =  rating;
        this.comment  =  comment;
    }

    public Review() {}

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id  =  id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user  =  user;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel  =  hotel;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating  =  rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment  =  comment;
    }
}
