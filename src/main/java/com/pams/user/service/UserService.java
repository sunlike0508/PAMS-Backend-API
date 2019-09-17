package com.pams.user.service;

import com.pams.common.protocol.CommonResponseVO;
import com.pams.user.dto.User;

public interface UserService {
	public CommonResponseVO signUpUser(User user);
}
