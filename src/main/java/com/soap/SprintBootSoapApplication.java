package com.soap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.soap.*")
public class SprintBootSoapApplication {

	public static void main(String[] args) {
		SpringApplication.run(SprintBootSoapApplication.class, args);
	}

}
