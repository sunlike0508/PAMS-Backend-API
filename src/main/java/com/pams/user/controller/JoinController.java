package com.pams.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pams.common.protocol.CommonResponseVO;
import com.pams.common.protocol.CommonResultCode;
import com.pams.user.dto.User;
import com.pams.user.repo.JoinUserRepository;

@RestController
public class JoinController {
	
	@Autowired
	private JoinUserRepository joinDao;
	
	@PostMapping(path = "/join")
    public CommonResponseVO joinUser(User user) {
		User joinUser = joinDao.save(user);
		
		CommonResponseVO response = new CommonResponseVO();
		response.setResponseCode(CommonResultCode.SUCCESS_NORMAL.getCode());
		response.setResponseMessage(CommonResultCode.SUCCESS_NORMAL.getMessage());
		response.setResponseData(joinUser);
        return response;
    }
	
	@PostMapping(path = "/list")
	public List<User> userList(){
		return (List<User>) joinDao.findAll();
	}
}
