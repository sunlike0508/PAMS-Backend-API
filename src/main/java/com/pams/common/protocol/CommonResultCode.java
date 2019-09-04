package com.pams.common.protocol;

public enum CommonResultCode {
	SUCCESS_NORMAL("S000", "성공"),

	ERROR_SYSTEM_ERROR("E001", "시스템에러"),
	
	ERROR_INVALID_PARAMETER("E002", "올바르지 않은 파라미터"),
	
	ERROR_UNIQUE_CONSTRAINT_VIOLATED("E003", "이미 존재하는 데이터입니다.");

	private String code;
	private String messsage;

	private CommonResultCode(final String code, final String message) {
		this.code = code;
		this.messsage = message;
	}

	public String getCode() {
		return this.code;
	}

	public String getMessage() {
		return this.messsage;
	}
}
