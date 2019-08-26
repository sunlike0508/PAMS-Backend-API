package com.pams.payment.service;

import org.springframework.stereotype.Service;

import com.pams.payment.dto.Payment;

@Service
public interface PaymentService{

	public Payment savePayment(Payment payment);
}
