package com.epam.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.authority.mapping.GrantedAuthoritiesMapper;
import org.springframework.security.core.authority.mapping.SimpleAuthorityMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.epam.service.AppUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private AppUserDetailsService appUserDetailsService;

	@Bean
	public DaoAuthenticationProvider getAuthenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(appUserDetailsService);
		provider.setPasswordEncoder(new BCryptPasswordEncoder(11));
		provider.setAuthoritiesMapper(getAuthoritiesMapper());
		return provider;
	}

	@Bean
	public GrantedAuthoritiesMapper getAuthoritiesMapper() {
		SimpleAuthorityMapper mapper = new SimpleAuthorityMapper();
		mapper.setConvertToUpperCase(true);
		mapper.setDefaultAuthority("USER");
		return mapper;
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {

		http.csrf().disable().authorizeRequests().antMatchers("/", "index.html").permitAll().anyRequest()
				.authenticated().and().httpBasic();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.authenticationProvider(getAuthenticationProvider());
	}

//	@Bean
//	public UserDetailsService userDetailsService() {
//		List<UserDetails> users = new ArrayList<>();
//		
//		users.add(User.withDefaultPasswordEncoder().username("pavan").password("password").roles("USER","ADMIN").build());
//		
//		users.add(User.withDefaultPasswordEncoder().username("kumar").password("password").roles("USER").build());
//		
//		return new InMemoryUserDetailsManager(users);
//	}
}
