package com.pams.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.pams.common.protocol.CommonResponseVO;
import com.pams.common.protocol.CommonResultCode;
import com.pams.user.dto.User;
import com.pams.user.predicate.UserPredicate;
import com.pams.user.repo.UserRepository;

import lombok.extern.java.Log;

@Log
@JsonSerialize
@Service("userService")
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepo;
	
	@Override
	public CommonResponseVO signUpUser(User user) {
		
		//need validation check
		User signUpUser = userRepo.save(user);
		
		CommonResponseVO response = new CommonResponseVO();
		response.setResponseCode(CommonResultCode.SUCCESS_NORMAL.getCode());
		response.setResponseMessage(CommonResultCode.SUCCESS_NORMAL.getMessage());
		response.setResponseData(signUpUser);
		
		return response;
	}

	@Override
	public CommonResponseVO getUserList(User user) {
		List<User> userList = (List<User>) userRepo.findAll(UserPredicate.searchCondition(user));
		
		CommonResponseVO response = new CommonResponseVO();
		response.setResponseCode(CommonResultCode.SUCCESS_NORMAL.getCode());
		response.setResponseMessage(CommonResultCode.SUCCESS_NORMAL.getMessage());
		response.setResponseDataList(userList);
	
		return response;
	}

}
