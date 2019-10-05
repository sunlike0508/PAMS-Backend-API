package com.pams.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.pams.payment.dto.Payment;
import com.pams.payment.predicate.PaymentPredicate;
import com.pams.payment.repo.PaymentRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class PamsPaymentJPATests {
	
	/*
	 * 1. 단위 별로 테스트 하기 위해선 원하는 테스트 단위(@Test)를 제외한 나머지를 주석 처리 후 실행.
	 * 2. 실행 시에는 기존 실행이 아닌 JUNIT 테스트 실행으로 테스트 진행. 단축키는  Alt+Shift+X+T
	 */

    @Autowired
    private PaymentRepository paymentRepo;
    
    @Test
    public void paymentSaveTest() {
        Payment payment = new Payment();
        payment.setCategory("PCC01");
        payment.setPaymentCode("PMC01");
        Payment savePayment= paymentRepo.save(payment);
        
        assertThat(savePayment.getId(), is(notNullValue()));
        assertThat(savePayment.getCategory(), is(notNullValue()));
        assertThat(savePayment.getPaymentCode(), is(notNullValue()));
    }

    @Test
    public void paymentFindAllTest() {
    	Payment payment = new Payment();
    	List<Payment> paymentList = (List<Payment>) paymentRepo.findAll(PaymentPredicate.searchCondition(payment));
    	assertThat(paymentList, is(notNullValue()));
//    	assertThat(paymentList).isNotEmpty(); // 위와 같은 내용 위에 jar import차이
    	
//    	Payment cateCodePayment = new Payment();
//    	cateCodePayment.setCategory("PCC01");
//    	
//    	Payment payCodePayment = new Payment();
//    	payCodePayment.setCategory("PMC01");
    	
//    	assertThat(paymentList).isNotEmpty().contains(cateCodePayment).doesNotContain(payCodePayment); // 조회된 리스트에 원하는 DTO가 있는지 없는지 check하는 테스트 유닛
    }

    @Test
    public void paymentFindIdTest() {
    	Payment payment = new Payment();
    	payment.setId(5);
    	
    	Payment findPayment = paymentRepo.findById(payment.getId());
    	assertThat(findPayment.getId(), is(notNullValue()));
    }
    
	@Test
	public void paymentDeleteIdTest() {
		Payment payment = new Payment();
		payment.setId(3);

		paymentRepo.deleteById(payment.getId());

		Payment findPayment = paymentRepo.findById(payment.getId());

		assertThat(findPayment, is(nullValue()));
	}

}
