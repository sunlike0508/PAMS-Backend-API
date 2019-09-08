package com.pams.payment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.pams.common.protocol.CommonResponseVO;
import com.pams.common.protocol.CommonResultCode;
import com.pams.common.util.CommonUtils;
import com.pams.payment.dto.Payment;
import com.pams.payment.predicate.PaymentPredicate;
import com.pams.payment.repo.PaymentRepository;

import lombok.extern.java.Log;


@Log
@JsonSerialize
@Service("PaymentService")
public class PaymentServiceImpl implements PaymentService{
	
	@Autowired
	private PaymentRepository paymentRepo;

	@Override
	@Transactional(propagation=Propagation.REQUIRED, isolation = Isolation.DEFAULT)
	public CommonResponseVO makePayment(Payment payment) {
		
		log.info(payment.toString());
		//need validation check payment
		Payment savePayment = paymentRepo.save(payment);
		
		CommonResponseVO response = new CommonResponseVO();
		response.setResponseCode(CommonResultCode.SUCCESS_NORMAL.getCode());
		response.setResponseMessage(CommonResultCode.SUCCESS_NORMAL.getMessage());
		response.setResponseData(savePayment);
		
		return response;
	}

	@Override
	@Transactional(readOnly = true)
	public CommonResponseVO getPaymentList(Payment payment) {
		
		//need validation check payment
		
		log.info("payment_code: " + payment.getPaymentCode());
		log.info("start_date: " + payment.getStart_date());
		log.info("end_date: " + payment.getEnd_date());
		
		List<Payment> paymentList = (List<Payment>) paymentRepo.findAll(PaymentPredicate.searchCondition(payment));
				
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
		//need validation check payment
		
		Payment updatePayment = paymentRepo.findById(payment.getId());
		
		updateCheckNullColumn(updatePayment, payment);
		
		updatePayment = paymentRepo.save(updatePayment);
		
		CommonResponseVO response = new CommonResponseVO();
		response.setResponseCode(CommonResultCode.SUCCESS_NORMAL.getCode());
		response.setResponseMessage(CommonResultCode.SUCCESS_NORMAL.getMessage());
		response.setResponseData(updatePayment);

		return response;
	}

	private void updateCheckNullColumn(Payment updatePayment, Payment payment) {
		
		if(!CommonUtils.isNull(payment.getCategory())) {
			updatePayment.setCategory(payment.getCategory());
		}
		if(!CommonUtils.isNull(payment.getContents())) {
			updatePayment.setContents(payment.getContents());
		}
		if(!CommonUtils.isNull(payment.getPayDate())) {
			updatePayment.setPayDate(payment.getPayDate());
		}
		if(!CommonUtils.isNull(payment.getPaymentCode())) {
			updatePayment.setPaymentCode(payment.getPaymentCode());
		}
		if(!CommonUtils.isNull(payment.getPrice())) {
			updatePayment.setPrice(payment.getPrice());
		}
		if(!CommonUtils.isNull(payment.getIsActive())) {
			updatePayment.setIsActive(payment.getIsActive());
		}
	}

	@Override
	public CommonResponseVO deletePayment(Payment payment) {
	
		//paymentRepo.delete(payment);
		paymentRepo.deleteById(payment.getId());
		
		CommonResponseVO response = new CommonResponseVO();
		response.setResponseCode(CommonResultCode.SUCCESS_NORMAL.getCode());
		response.setResponseMessage(CommonResultCode.SUCCESS_NORMAL.getMessage());
		//response.setResponseData(updatePayment);
		
		return null;
	}
}
