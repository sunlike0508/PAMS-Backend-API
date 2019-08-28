package com.pams.payment.dto;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name="TBL_PAYMENT")
@EqualsAndHashCode(of="payId")
public class Payment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="pay_id")
	private int payId;
	
	@CreationTimestamp
	private Timestamp write_date;
	
	@Column(name="payment_code", length = 5)
	private String paymentCode;
	
	@Column(name="price", length = 2)
	private int price;
	
	@Column(name="category", length = 5)
	private String category;
	
	@Column(name="contents")
	private String contents;
	
	@Column(name="is_active", length = 1)
	private String isActive;
	
	@CreationTimestamp
	private Timestamp create_date;
	
	@UpdateTimestamp
	private Timestamp update_date;
	
	@Column(name="creater_id", length = 50)
	private String createrId;
}
