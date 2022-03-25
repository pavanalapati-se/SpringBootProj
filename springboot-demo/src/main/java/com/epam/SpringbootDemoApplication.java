package com.epam;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
//@Import(Config.class)
public class SpringbootDemoApplication implements CommandLineRunner{

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SpringbootDemoApplication.class, args);
		
		Greeting greeting = context.getBean(Greeting.class);
		greeting.greetAll();
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Run method executing .......................");
		
	}

}
