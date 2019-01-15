package com.springassign.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springassign.model.AuthGroup;

public interface AuthRepo extends JpaRepository<AuthGroup, Long> 
{	
	List<AuthGroup> findByUsername(String username); 

}
