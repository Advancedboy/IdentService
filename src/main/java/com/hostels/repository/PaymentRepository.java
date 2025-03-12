package com.hostels.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hostels.model.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

}
