package com.hostels.service;

import com.hostels.dto.PaymentCreateDto;
import com.hostels.dto.PaymentDto;
import com.hostels.enums.PaymentMethod;
import com.hostels.enums.PaymentStatus;
import com.hostels.model.Booking;
import com.hostels.model.Payment;
import com.hostels.repository.BookingRepository;
import com.hostels.repository.PaymentRepository;
import org.springframework.stereotype.Service;


@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;
    private final BookingRepository bookingRepository;

    public PaymentService(PaymentRepository paymentRepository,
                          BookingRepository bookingRepository) {
        this.paymentRepository = paymentRepository;
        this.bookingRepository = bookingRepository;
    }

    public PaymentDto createPayment(PaymentCreateDto paymentCreateDto) {
        // Преобразуем DTO в сущность
        Payment payment = paymentCreateDto.toEntity();

        // Получаем объект Booking по ID
        Booking booking = bookingRepository.findById(paymentCreateDto.getBookingId())
                .orElseThrow(() -> new IllegalStateException("Booking not found"));
        payment.setBooking(booking);

        // Сохраняем платеж
        Payment savedPayment = paymentRepository.save(payment);

        // Возвращаем DTO с полными данными
        return PaymentDto.fromEntity(savedPayment);
    }
}
