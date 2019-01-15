package com.springassign.repo;
import org.springframework.data.jpa.repository.JpaRepository;

import com.springassign.model.User;

public interface UserRepo extends JpaRepository<User,Integer>{
	
	User findByUsername(String userName);

}
