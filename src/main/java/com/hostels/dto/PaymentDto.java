package com.hostels.dto;

import com.hostels.enums.PaymentMethod;
import com.hostels.enums.PaymentStatus;
import com.hostels.model.Payment;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDto {
    private Long id;
    private Long bookingId;
    private double amount;
    private PaymentMethod method;
    private PaymentStatus status;
    private LocalDateTime paymentData;

    public static PaymentDto fromEntity(Payment payment) {
        return new PaymentDto(
                payment.getId(),
                payment.getBooking() != null ? payment.getBooking().getId() : null,
                payment.getAmount(),
                payment.getPaymentMethod(),
                payment.getStatus(),
                payment.getPaymentDate()
        );
    }
}
