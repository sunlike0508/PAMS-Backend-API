package com.pams.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pams.user.User;
import com.pams.user.dao.JoinUserDao;

@Controller
public class JoinController {
	
	@Autowired
	private JoinUserDao joinDao;
	
	@GetMapping(path = "/join")
    @ResponseBody
    public User joinUser(User user) {
		User user2 = new User();
		user2.setUser_id("sunlike0508");
		user2.setEmail("thesin1989@gmail.com");
		user2.setGrade("08");
		user2.setName("신선호");
		
		joinDao.save(user2);
		
        return user2;
    }
	
	@GetMapping(path = "/list")
    @ResponseBody
	public List<User> userList(){
		return (List<User>) joinDao.findAll();
	}
}
