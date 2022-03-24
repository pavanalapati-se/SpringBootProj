package com.epam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class Greeting {
	
	
	private static Logger log = LoggerFactory.getLogger(Greeting.class);
	
	@Value("${greeting.message:Nice Day!}")
	private String message;
	
	public void greetAll() {
		
		log.debug("Hi");
		log.info(message);
		log.warn("Its lunch time!...");
		log.error("no lunch break");
		
		
	}

}
