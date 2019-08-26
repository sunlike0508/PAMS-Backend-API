package com.pams.common.protocol;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@JsonInclude(Include.NON_NULL)
public class CommonResponseVO {
	private String responseCode;
	private String responseMessage;
	private Object responseData;
}
