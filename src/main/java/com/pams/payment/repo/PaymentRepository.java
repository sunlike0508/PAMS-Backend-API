package com.pams.payment.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pams.payment.dto.Payment;

public interface PaymentRepository extends CrudRepository<Payment, Long>{
}
