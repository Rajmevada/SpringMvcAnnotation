package com.rajmevada.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rajmevada.model.User;
import com.rajmevada.model.UserProfile;

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserService userService;

	@Transactional
	public UserDetails loadUserByUsername(String sso) throws UsernameNotFoundException {
		
		User user=userService.findBySso(sso);
		if(user== null){
			throw new UsernameNotFoundException("User name can not be found");
		}
		return new org.springframework.security.core.userdetails.User(user.getSsoId(), user.getPassword(), user.getState().equals("Active"), true, true, true, getGrantedAuthorities(user));
	}

	private List<GrantedAuthority> getGrantedAuthorities(User user) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

		for (UserProfile userProfile : user.getUserProfiles()) {
			System.out.println("UserProfile : " + userProfile);
			authorities.add(new SimpleGrantedAuthority("ROLE_" + userProfile.getType()));
		}
		System.out.print("authorities :" + authorities);
		return authorities;
	}

}
