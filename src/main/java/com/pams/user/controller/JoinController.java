package com.pams.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pams.common.protocol.CommonResponseVO;
import com.pams.common.protocol.CommonResultCode;
import com.pams.user.dao.JoinUserDao;
import com.pams.user.dto.User;

@RestController
public class JoinController {
	
	@Autowired
	private JoinUserDao joinDao;
	
	@PostMapping(path = "/join")
    public CommonResponseVO joinUser(User user) {
		CommonResponseVO response = new CommonResponseVO();
		User joinUser = joinDao.save(user);
		
		response.setResponseCode(CommonResultCode.SUCCESS_NORMAL.getCode());
		response.setResponseMessage(CommonResultCode.SUCCESS_NORMAL.getMessage());
		response.setResponseData(joinUser);
        return response;
    }
	
	@GetMapping(path = "/list")
    @ResponseBody
	public List<User> userList(){
		return (List<User>) joinDao.findAll();
	}
}
