package com.data.base;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(BaseApplication.class, args);
	}
	@Value("${spring.data.mongodb.uri:NOT_FOUND}")
	private String mongoUri;

	@PostConstruct
	public void verifyMongo() {
		System.out.println(">>> Mongo URI from ENV = " +
				System.getProperty("spring.data.mongodb.uri"));
	}
}
