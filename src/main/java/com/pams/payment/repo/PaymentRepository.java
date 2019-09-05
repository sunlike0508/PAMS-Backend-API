package com.pams.payment.repo;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

import com.pams.payment.dto.Payment;

public interface PaymentRepository extends CrudRepository<Payment, Long>, QuerydslPredicateExecutor<Payment>{

	Payment findById(int id);

}
