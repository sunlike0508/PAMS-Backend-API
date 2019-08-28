package com.pams.payment.repo;

import java.util.Collection;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.pams.payment.dto.Payment;

public interface PaymentRepository extends CrudRepository<Payment, Long>{
	
	public List<Payment> findPaymentByPaymentCode(String paymentCode);
	
//	public Collection<Payment> findByWriter(String writer);
//	
//	public Collection<Payment> findByWriterContaining(String writer);
//	
//	public Collection<Payment> findByTitleContainingOrContentContaining(String title, String content);
//	
//	public Collection<Payment> findByTitleContainingAndBnoGreaterThan(String keyword, Long num);
//	
//	public Collection<Payment> findByBnoGreaterThanOrderByBnoDesc(Long bno);
//	
//	public List<Payment> findByBnoGreaterThanOrderByBnoDesc(Long bno, Pageable paging);
//	
//	public Page<Payment> findByBnoGreaterThan(Long bno, Pageable paging);
}
