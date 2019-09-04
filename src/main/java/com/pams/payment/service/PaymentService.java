package com.pams.payment.service;

import com.pams.common.protocol.CommonResponseVO;
import com.pams.payment.dto.Payment;

public interface PaymentService{

	public CommonResponseVO savePayment(Payment payment);

	public CommonResponseVO getPaymentList(Payment payment);

	public CommonResponseVO updatePayment(Payment payment);
}
