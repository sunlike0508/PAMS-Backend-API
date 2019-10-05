package com.pams.test;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.MockRestServiceServer;

import com.pams.payment.dto.Payment;
import com.pams.payment.service.PaymentService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PamsPaymentApiTests {

//	@Rule
//    public ExpectedException thrown = ExpectedException.none();
//    
//	@Autowired
//    private PaymentService paymentService;
//    
//    @Autowired
//    private MockRestServiceServer server;
//	
//	@Test
//	public void testMakePayment() {
//	       server.expect(requestTo("/pams/makePayment"))
//           .andRespond(withSuccess(new ClassPathResource("/test.json", getClass()), MediaType.APPLICATION_JSON));
//	       
//	       Payment payment = new Payment();
//	       
//		   List<Payment> listPayment = paymentService.getPaymentList(payment);
//		   assertThat(book.getId(), is(notNullValue()));
//		   assertThat(book.getTitle(), is("title"));
//		   assertThat(book.getPrice(), is(1000D));
//	}
	
	// 조회 
	/* 필요 데이터 : payment_code, start_date,  end_date -> validation check 하는 메소드 작성 -> 이거에 대한 테스트 코드 필요.
		payment_code가 PMC00,01,02가 아니면 error 리턴
		start, end date 날짜 형식이 아니면 error 리턴
	 */

	/* 성공 200 1. 데이타가 있냐 ? responseDataList 길이가  1이상이다. 2. 데이터가 없냐? 빈값을 출력.
	 * 실패 
	 * 
	 */

}
