package com.backend.clase13;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.DriverManager;

@SpringBootApplication
public class Clase13Application {

	private static Logger LOGGER = LoggerFactory.getLogger(Clase13Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Clase13Application.class, args);
		crearTabla();
		LOGGER.info("Clase13Application is now running...");
	}

	private static void crearTabla(){
		Connection connection = null;
		try {
			Class.forName("org.h2.Driver");
			connection = DriverManager.getConnection("jdbc:h2:~/c124clinica;INIT=RUNSCRIPT FROM 'create.sql'", "sa", "sa");

		} catch (Exception e){
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (Exception ex){
				ex.printStackTrace();
			}
		}
	}

}
