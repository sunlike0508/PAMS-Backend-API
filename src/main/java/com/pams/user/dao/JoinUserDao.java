package com.pams.user.dao;

import org.springframework.data.repository.CrudRepository;

import com.pams.user.dto.User;

public interface JoinUserDao extends CrudRepository<User, Long>{

}
