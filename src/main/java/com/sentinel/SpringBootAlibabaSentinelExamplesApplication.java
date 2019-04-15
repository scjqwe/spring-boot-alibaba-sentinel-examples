package com.sentinel;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootAlibabaSentinelExamplesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootAlibabaSentinelExamplesApplication.class, args);
	}

	@Bean
	public DataLoader dataLoader() {
		return new DataLoader();
	}

	static class DataLoader implements CommandLineRunner {

		@Override
		public void run(String... strings) throws Exception {
			System.out.println("Loading data...");
		}
	}
}
