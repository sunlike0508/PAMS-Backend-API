package com.pams.payment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pams.common.protocol.CommonResponseVO;
import com.pams.common.protocol.CommonResultCode;
import com.pams.payment.dto.Payment;
import com.pams.payment.service.PaymentService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/pams")
public class PaymentController {
	
	PaymentService paymentService;
	
	@PostMapping("/payment.do")
    public @ResponseBody CommonResponseVO makePayment(@RequestBody Payment payment) {
		
		payment = paymentService.savePayment(payment);
		
		CommonResponseVO response = new CommonResponseVO();
		response.setResponseCode(CommonResultCode.SUCCESS_NORMAL.getCode());
		response.setResponseMessage(CommonResultCode.SUCCESS_NORMAL.getMessage());
		response.setResponseData(payment);
		
        return response;
    }
}
