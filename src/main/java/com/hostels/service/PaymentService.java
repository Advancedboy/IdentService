package com.hostels.service;

import com.hostels.enums.PaymentMethod;
import com.hostels.enums.PaymentStatus;
import com.hostels.model.Booking;
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

    public Payment processPayment(Long bookingId, double amount, PaymentMethod method) {
        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new RuntimeException("Booking not found"));

        Payment payment = new Payment();
        payment.setBooking(booking);
        payment.setAmount(amount);
        payment.setPaymentMethod(method);
        payment.setStatus(PaymentStatus.COMPLETED);

        return paymentRepository.save(payment);
    }
}
