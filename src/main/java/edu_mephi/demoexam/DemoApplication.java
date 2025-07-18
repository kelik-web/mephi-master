package edu_mephi.demoexam;

import edu_mephi.demoexam.enums.Country;
import edu_mephi.demoexam.model.User;
import edu_mephi.demoexam.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import java.util.List;

@SpringBootApplication
public class DemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner initData(UserRepository userRepository) {
		return args -> {
			userRepository.saveAll(List.of(
					new User(null, "Alice", 30, Country.USA),
					new User(null, "Bob", 25, Country.RUSSIA),
					new User(null, "Charlie", 40, Country.ARMENIA),
					new User(null, "Diana", 22, Country.POLAND),
					new User(null, "Ethan", 28, Country.BRAZIL)
			));
		};
	}
}