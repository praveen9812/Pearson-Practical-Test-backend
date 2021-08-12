package com.country.crud2;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.country.crud2.model.Country;
import com.country.crud2.repo.CrudRepo;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
public class CrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudApplication.class, args);
		System.out.print("budusaranai.....!");
	}

	@Bean
	CommandLineRunner runner(CrudRepo countryRepository) {
		return args -> {
			// read json and write to db
			ObjectMapper mapper = new ObjectMapper();
			TypeReference<List<Country>> typeReference = new TypeReference<List<Country>>(){};
			InputStream inputStream = TypeReference.class.getResourceAsStream("/countries.json");
			try {
				List<Country> users = mapper.readValue(inputStream,typeReference);
				countryRepository.saveAll(users);
				System.out.println("Data saved");
			} catch (IOException e){
				System.out.println("Unable to save: " + e.getMessage());
			}
		};
	}
}
