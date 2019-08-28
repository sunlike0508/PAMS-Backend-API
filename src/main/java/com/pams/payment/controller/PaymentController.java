package com.pams.payment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pams.common.protocol.CommonResponseVO;
import com.pams.payment.dto.Payment;
import com.pams.payment.service.PaymentService;


@RestController
@RequestMapping("/pams")
public class PaymentController {
	
	@Autowired
	private PaymentService paymentService;
	
	@RequestMapping(value = "/makePayment", method = RequestMethod.POST)
	public @ResponseBody CommonResponseVO makePayment(@RequestBody Payment payment) {
				
		CommonResponseVO response = paymentService.savePayment(payment);
		
        return response;
    }
	
	@RequestMapping(value = "/getPaymentList", method = RequestMethod.POST)
	public @ResponseBody CommonResponseVO getPaymentList(@RequestBody Payment payment) {
				
		CommonResponseVO response = paymentService.getPaymentList(payment);
		
        return response;
    }
}
