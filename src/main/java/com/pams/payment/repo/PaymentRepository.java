package com.pams.payment.repo;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

import com.pams.payment.dto.Payment;

public interface PaymentRepository extends CrudRepository<Payment, Long>, QuerydslPredicateExecutor<Payment>{
	
	public List<Payment> findByPaymentCode(String paymentCode);

	public List<Payment> findByWriteDateBetween(Timestamp start_date, Timestamp end_date);

	public List<Payment> findByPaymentCodeAndWriteDateBetween(String paymentCode, Timestamp start_date, Timestamp end_date);
}
