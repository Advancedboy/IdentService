package com.hostels.dto;

import com.hostels.model.Review;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReviewCreateDto {

    private Long userId;
    private Long hotelId;
    private double rating;
    private String comment;

    // Метод для преобразования ReviewCreateDto в сущность Review
    public Review toEntity() {
        Review review = new Review();
        review.setRating(this.rating);
        review.setComment(this.comment);
        return review;
    }
}
