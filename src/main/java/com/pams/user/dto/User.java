package com.pams.user.dto;

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
@Table(name="TBL_USER")
@EqualsAndHashCode(of="id")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", length = 50, nullable = false)
	private Long id;
	
	@Column(name="email", length = 50, nullable = false)
	private String email;
	
	@Column(name="name", length = 50, nullable = false)
	private String name;
	
	@Column(name="grade", length = 2)
	private String grade;
	
	@Column(name="club_code", length = 5)
	private String clubCode;
	
	@Column(name="role_code", length = 5)
	private String roleCode;
	
	@Column(name="is_active", length = 1)
	private String isActive;
	
	@CreationTimestamp
	private Timestamp create_date;
	
	@UpdateTimestamp
	private Timestamp update_date;
}
