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

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@NoArgsConstructor
@Table(name="TBL_PAYMENT")
public class Payment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="pay_id")
	private int pay_id;
	
//	@CreationTimestamp
//	private Timestamp write_date;
	
	@Column(name="payment_code", length = 5)
	private String payment_code;
	
	@Column(name="price", length = 2)
	private int price;
	
	@Column(name="category", length = 5)
	private String category;
	
	@Column(name="contents")
	private String contents;
	
	@Column(name="is_active", length = 1)
	private String is_active;
	
//	@CreationTimestamp
//	private Timestamp create_date;
//	
//	@UpdateTimestamp
//	private Timestamp update_date;
//	
//	@Column(name="creater_id", length = 50)
//	private String creater_id;
}
