package com.pams.payment.service;

import java.util.List;
//import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pams.common.protocol.CommonResponseVO;
import com.pams.common.protocol.CommonResultCode;
import com.pams.payment.dto.Payment;
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
		
		//List<Payment> paymentList = (List<Payment>) paymentRepo.findAll();
		List<Payment> paymentList = (List<Payment>) paymentRepo.findPaymentByPaymentCode(payment.getPaymentCode());
		
		//Logger.getLogger("Code: " + payment.getPaymentCode());
		log.info("Code: " + payment.getPaymentCode());
				
		CommonResponseVO response = new CommonResponseVO();
		response.setResponseCode(CommonResultCode.SUCCESS_NORMAL.getCode());
		response.setResponseMessage(CommonResultCode.SUCCESS_NORMAL.getMessage());
		response.setResponseDataList(paymentList);
		
		return response;
	}

}
