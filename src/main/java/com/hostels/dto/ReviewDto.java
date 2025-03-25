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
public class ReviewDto {

    private Long id;
    private Long userId;
    private Long hotelId;
    private double rating;
    private String comment;

    public static ReviewDto fromEntity(Review review) {
        return new ReviewDto(
                review.getId(),
                review.getUser().getId(),
                review.getHotel().getId(),
                review.getRating(),
                review.getComment()
        );
    }
}
