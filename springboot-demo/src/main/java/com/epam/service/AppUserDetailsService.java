package com.epam.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.epam.dao.AuthGroupRepository;
import com.epam.dao.UserRepository;
import com.epam.dto.UserPrincipal;
import com.epam.entity.AuthGroup;
import com.epam.entity.User;

@Service
public class AppUserDetailsService implements UserDetailsService {

	private final UserRepository repository;

	private final AuthGroupRepository authGroupRepository;

	public AppUserDetailsService(UserRepository repository, AuthGroupRepository authGroupRepository) {
		super();
		this.repository = repository;
		this.authGroupRepository = authGroupRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = repository.findByUsername(username);
		if (null == user) {
			throw new UsernameNotFoundException("Cannot find username :" + username);
		}
		List<AuthGroup> authGroups = authGroupRepository.findByUsername(username);
		return new UserPrincipal(user, authGroups);
	}

}
