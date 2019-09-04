package com.pams.payment.predicate;

import java.sql.Timestamp;

import com.pams.payment.dto.Payment;
import com.pams.payment.dto.QPayment;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;

import lombok.extern.java.Log;

@Log
public class PaymentPredicate {
	
	public static Predicate search(Payment payment) {
		log.info("payment_code: " + payment.getPaymentCode());
		log.info("start_date: " + payment.getStart_date());
		log.info("end_date: " + payment.getEnd_date());
		
		QPayment paymentGroup = QPayment.payment;
		
		String paymentCode = payment.getPaymentCode();
		Timestamp startDate = payment.getStart_date();
		Timestamp endDate = payment.getEnd_date();
		
		BooleanBuilder builder = new BooleanBuilder();
		
		if(paymentCode !=null) {
			builder.and(paymentGroup.paymentCode.eq(paymentCode));
		}
		
		if(startDate !=null) {
			builder.and(paymentGroup.writeDate.between(startDate, endDate));
		}
		
		return builder;
	}

}
