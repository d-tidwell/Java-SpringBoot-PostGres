package com.example.PostGres.MVP.PostGres.MVP.Student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {
	
	@Bean
	CommandLineRunner commandLineRunner(
			StudentRepository repository) {
		return args -> {
			Student mariam = new Student(
					"Miriam",
					"miriam@gmail.com",
					LocalDate.of(2000, Month.JANUARY,5),
					23
					);
					
			Student alex = new Student(
					"Alex",
					"Alex@gmail.com",
					LocalDate.of(1997, Month.OCTOBER,3),
					28
					);
			
			repository.saveAll(List.of(mariam, alex));
			
		};
	}
}
