package com.example.space;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class SpaceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpaceApplication.class, args);
	}

}
