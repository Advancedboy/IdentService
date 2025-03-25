package com.hostels.service;

import com.hostels.dto.ReviewCreateDto;
import com.hostels.dto.ReviewDto;
import com.hostels.model.Hotel;
import com.hostels.model.Review;
import com.hostels.model.User;
import com.hostels.repository.HotelRepository;
import com.hostels.repository.ReviewRepository;
import com.hostels.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;
    private final HotelRepository hotelRepository;

    public ReviewService(ReviewRepository reviewRepository,
                         UserRepository userRepository,
                         HotelRepository hotelRepository) {
        this.reviewRepository = reviewRepository;
        this.userRepository = userRepository;
        this.hotelRepository = hotelRepository;
    }

    public ReviewDto createReview(ReviewCreateDto reviewCreateDto) {
        // Получаем User и Hotel из базы данных
        User user = userRepository.findById(reviewCreateDto.getUserId())
                .orElseThrow(() -> new IllegalStateException("User not found"));
        Hotel hotel = hotelRepository.findById(reviewCreateDto.getHotelId())
                .orElseThrow(() -> new IllegalStateException("Hotel not found"));

        // Преобразуем DTO в сущность Review
        Review review = reviewCreateDto.toEntity();
        review.setUser(user);
        review.setHotel(hotel);

        // Сохраняем отзыв в базе данных
        Review savedReview = reviewRepository.save(review);

        // Возвращаем DTO
        return ReviewDto.fromEntity(savedReview);
    }
}
