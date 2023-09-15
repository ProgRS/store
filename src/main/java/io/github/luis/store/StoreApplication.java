package io.github.luis.store;

import io.github.luis.store.models.User;
import io.github.luis.store.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EntityScan(basePackages = "io.github.luis.store")
public class StoreApplication {

	@Bean
	public CommandLineRunner commandLineRunner(
			@Autowired UserRepository repository){
		return args -> {
			User user = new User();
		};
	}


	public static void main(String[] args) {

		SpringApplication.run(StoreApplication.class, args);
	}

}
