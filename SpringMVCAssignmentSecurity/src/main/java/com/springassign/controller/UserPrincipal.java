package com.springassign.controller;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.springassign.model.User;
import com.springassign.model.AuthGroup;

public class UserPrincipal implements UserDetails{

	private User user;
	private List<AuthGroup> authGroups;

	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		//return Collections.singleton(new SimpleGrantedAuthority("USER"));
		if(authGroups == null)
			return Collections.emptySet();
		
		Set<SimpleGrantedAuthority> grantedAuths = new HashSet<>();
		for(AuthGroup group : authGroups)
		{
			grantedAuths.add(new SimpleGrantedAuthority(group.getAuthGroup()));
		}
		
		return grantedAuths;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return user.getUsername();
	}

	public UserPrincipal(User user, List<AuthGroup> authGroups) {
		super();
		this.user = user;
		this.authGroups = authGroups;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
