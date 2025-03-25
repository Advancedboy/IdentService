package com.hostels.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
}
