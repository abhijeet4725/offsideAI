package com.abhijeet.offsideAi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class OffsideAiApplication {

	public static void main(String[] args) {
		SpringApplication.run(OffsideAiApplication.class, args);
	}

}
