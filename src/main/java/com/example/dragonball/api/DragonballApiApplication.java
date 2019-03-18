package com.example.dragonball.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.example.dragonball.api.config.property.DragonApiProperty;

@SpringBootApplication
@EnableConfigurationProperties(DragonApiProperty.class)
public class DragonballApiApplication {
	

	public static void main(String[] args) {
		SpringApplication.run(DragonballApiApplication.class, args);
	}

	
}
