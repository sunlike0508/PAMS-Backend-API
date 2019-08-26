package com.pams.user.dto;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@Entity
@Table(name="TBL_USER")
public class User {
	
	@Id 
	@Column(name="user_id", length = 50, nullable = false)
	private String user_id;
	
	@Column(name="email", length = 50, nullable = false)
	private String email;
	
	@Column(name="name", length = 50, nullable = false)
	private String name;
	
	@Column(name="grade", length = 2)
	private String grade;
	
	@Column(name="club_code", length = 5)
	private String club_code;
	
	@Column(name="is_active", length = 1)
	private String is_active;
	
	@CreationTimestamp
	private Timestamp create_date;
	
	@UpdateTimestamp
	private Timestamp update_date;
	
	@Column(name="creater_id", length = 50)
	private String creater_id;	
	
}
