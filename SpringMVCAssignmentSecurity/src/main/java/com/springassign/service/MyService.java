package com.springassign.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.springassign.controller.UserPrincipal;
import com.springassign.model.AuthGroup;
import com.springassign.model.User;
import com.springassign.repo.AuthRepo;
import com.springassign.repo.UserRepo;

@Service
public class MyService implements UserDetailsService {
	
	@Autowired
	public UserRepo userRepo;
	
	@Autowired
	public AuthRepo authrepo;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		System.out.println("load by username"+userName);
		
		User user = userRepo.findByUsername(userName);
		System.out.println("load by username"+user);
		System.out.println("load by username"+user.getPassword());
		if(user==null)
			throw new UsernameNotFoundException("User not found");
		
		List<AuthGroup> authGroups = authrepo.findByUsername(userName);
		
		//List<AuthGroup> authGroups = authGroupRepository.findByUsername(username);
		
		return new UserPrincipal(user,authGroups);
		
	}

}
