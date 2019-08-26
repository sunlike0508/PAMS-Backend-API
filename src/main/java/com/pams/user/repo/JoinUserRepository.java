package com.pams.user.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pams.user.dto.User;

@Repository
public interface JoinUserRepository extends CrudRepository<User, Long>{

}
