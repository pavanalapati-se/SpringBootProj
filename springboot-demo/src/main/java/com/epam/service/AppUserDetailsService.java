package com.epam.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.epam.dao.UserRepository;
import com.epam.dto.UserPrincipal;
import com.epam.entity.User;

@Service
public class AppUserDetailsService implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	
	
	public AppUserDetailsService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);
		if(null==user) {
			throw new UsernameNotFoundException(username);
		}
		return new UserPrincipal(user);
	}

}
