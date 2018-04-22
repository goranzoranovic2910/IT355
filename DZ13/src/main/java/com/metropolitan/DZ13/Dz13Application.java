package com.metropolitan.DZ13;

import com.metropolitan.configuration.SecurityConfiguration;
import com.metropolitan.configuration.WebMvcConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Dz13Application {

	public static void main(String[] args) {

		SpringApplication.run(new Class<?>[]{Dz13Application.class, SecurityConfiguration.class, WebMvcConfig.class }, args);
	}
}
