package com.hostels.dto;

import com.hostels.enums.PaymentMethod;
import com.hostels.enums.PaymentStatus;
import com.hostels.model.Payment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PaymentCreateDto {
    private Long bookingId;
    private double amount;
    private PaymentMethod paymentMethod;
    private PaymentStatus status;

    public Payment toEntity() {
        Payment payment = new Payment();
        payment.setAmount(this.amount);
        payment.setPaymentMethod(this.paymentMethod);
        payment.setStatus(this.status);
        // Дата будет установлена в сущности автоматически
        // payment.setPaymentDate(LocalDateTime.now());
        return payment;
    }
}
