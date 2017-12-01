package com.hurricane;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@ImportResource("classpath:consumer/hurricane-service-consumer.xml")
@SpringBootApplication
public class HurricaneWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(HurricaneWebApplication.class, args);
	}
}
