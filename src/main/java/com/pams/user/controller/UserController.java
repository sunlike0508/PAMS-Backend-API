package com.pams.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pams.common.protocol.CommonResponseVO;
import com.pams.common.protocol.CommonResultCode;
import com.pams.user.dto.User;
import com.pams.user.service.UserService;

@RestController
@RequestMapping("/pams")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	//Create
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
    public @ResponseBody CommonResponseVO signUpUser(@RequestBody User user) {
		
		CommonResponseVO response = userService.signUpUser(user);
	
        return response;
    }
}
