package com.pams.user.repo;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pams.user.dto.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>, QuerydslPredicateExecutor<User>{

}
