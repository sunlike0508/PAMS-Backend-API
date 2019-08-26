package com.pams.payment.service;

import com.pams.payment.dto.Payment;
import com.pams.payment.repo.PaymentRepository;

public class PaymentServiceImpl implements PaymentService{
	
	private PaymentRepository paymentRepo;

	@Override
	public Payment savePayment(Payment payment) {
		return paymentRepo.save(payment);
	}

}
