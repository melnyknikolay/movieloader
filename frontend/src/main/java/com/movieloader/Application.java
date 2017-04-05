package com.movieloader;

import com.movieloader.dao.impl.configuration.BatchConfiguration;
import com.movieloader.dao.impl.configuration.JpaConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(new Class<?>[] {Application.class, JpaConfig.class, BatchConfiguration.class}, args);
	}
}
