package com.epam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import com.epam.dao.AuthGroupRepository;
import com.epam.dao.UserRepository;
import com.epam.entity.AuthGroup;
import com.epam.entity.User;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
//@Import(Config.class)
@OpenAPIDefinition(info = @Info(title = "Vaccine Management Tool", version = "1.0", description = "Scheudle vaccine appointments"))
public class SpringbootDemoApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AuthGroupRepository authGroupRepository;
	
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SpringbootDemoApplication.class, args);

		Greeting greeting = context.getBean(Greeting.class);
		greeting.greetAll();
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("restarted again");
		System.out.println("Run method executing .......................");
		
		PasswordEncoder encoder = new BCryptPasswordEncoder(11);
		
		User user1 = new User();
		user1.setId(102);
		user1.setUsername("pavan");
		user1.setPassword(encoder.encode("password"));
		
		User user2 = new User();
		user2.setId(103);
		user2.setUsername("kumar");
		user2.setPassword(encoder.encode("password"));
		
		
		userRepository.save(user1);
		userRepository.save(user2);
		
		 
        AuthGroup authGroup = new AuthGroup();
        authGroup.setUsername("pavan");
        authGroup.setAuthGroup("ADMIN");
        
        AuthGroup authGroup1 = new AuthGroup();
        authGroup1.setUsername("kumar");
        authGroup1.setAuthGroup("USER");
        
        authGroupRepository.save(authGroup);
        authGroupRepository.save(authGroup1);
		
		
	
	}

	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();

		messageSource.setBasename("classpath:messages");
		messageSource.setDefaultEncoding("UTF-8");
		return messageSource;
	}

	@Bean
	public LocalValidatorFactoryBean getValidator() {
		LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
		bean.setValidationMessageSource(messageSource());
		return bean;
	}

}
