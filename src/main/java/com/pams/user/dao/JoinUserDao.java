package com.pams.user.dao;

import org.springframework.data.repository.CrudRepository;

import com.pams.user.User;

public interface JoinUserDao extends CrudRepository<User, Long>{

}
