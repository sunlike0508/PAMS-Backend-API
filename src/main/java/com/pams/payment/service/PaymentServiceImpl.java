package com.pams.payment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pams.common.protocol.CommonResponseVO;
import com.pams.common.protocol.CommonResultCode;
import com.pams.payment.dto.Payment;
import com.pams.payment.predicate.PaymentPredicate;
import com.pams.payment.repo.PaymentRepository;

import lombok.extern.java.Log;


@Log
@Service("PaymentService")
public class PaymentServiceImpl implements PaymentService{
	
	@Autowired
	private PaymentRepository paymentRepo;

	@Override
	@Transactional(propagation=Propagation.REQUIRED, isolation = Isolation.DEFAULT)
	public CommonResponseVO savePayment(Payment payment) {
		
		log.info(payment.toString());
		//need validation check login
		Payment savePayment = paymentRepo.save(payment);
		
		CommonResponseVO response = new CommonResponseVO();
		response.setResponseCode(CommonResultCode.SUCCESS_NORMAL.getCode());
		response.setResponseMessage(CommonResultCode.SUCCESS_NORMAL.getMessage());
		response.setResponseData(savePayment);
		
		return response;
	}

	@Override
	public CommonResponseVO getPaymentList(Payment payment) {
		log.info("payment_code: " + payment.getPaymentCode());
		log.info("start_date: " + payment.getStart_date());
		log.info("end_date: " + payment.getEnd_date());
		
		List<Payment> paymentList = (List<Payment>) paymentRepo.findAll(PaymentPredicate.search(payment));
				
		CommonResponseVO response = new CommonResponseVO();
		response.setResponseCode(CommonResultCode.SUCCESS_NORMAL.getCode());
		response.setResponseMessage(CommonResultCode.SUCCESS_NORMAL.getMessage());
		response.setResponseDataList(paymentList);
		
		return response;
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED, isolation = Isolation.DEFAULT)
	public CommonResponseVO updatePayment(Payment payment) {
		log.info(payment.toString());
		//need validation check login
		
		Payment savePayment = paymentRepo.save(payment);
		
		CommonResponseVO response = new CommonResponseVO();
		response.setResponseCode(CommonResultCode.SUCCESS_NORMAL.getCode());
		response.setResponseMessage(CommonResultCode.SUCCESS_NORMAL.getMessage());
		response.setResponseData(savePayment);

		return response;
	}
}
