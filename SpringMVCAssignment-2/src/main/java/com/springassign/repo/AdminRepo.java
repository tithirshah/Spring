package com.springassign.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springassign.model.Admins;


public interface AdminRepo extends JpaRepository<Admins,Integer > {
	
	List<Admins> findByAnameAndAid(String aname,int aid);

}
