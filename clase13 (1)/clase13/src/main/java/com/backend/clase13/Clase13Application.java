package com.backend.clase13;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Clase13Application {

	private static Logger LOGGER = LoggerFactory.getLogger(Clase13Application.class);
	public static void main(String[] args) {
		SpringApplication.run(Clase13Application.class, args);
		LOGGER.info("Clase13Application is now running...");
	}

}
