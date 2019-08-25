package com.pams.payment.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pams.payment.Payment;

@RestController
public class PaymentController {
	
	@RequestMapping(value = "/payment", method = RequestMethod.GET)
    public @ResponseBody Payment paymentTest() {
		
		Payment payment = new Payment();
		
		payment.setPay_id(112344);
		payment.setCategory("HAC01");
		
        return payment;
    }
}
