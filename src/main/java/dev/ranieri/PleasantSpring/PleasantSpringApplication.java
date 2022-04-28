package dev.ranieri.PleasantSpring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "dev.ranieri") // Tell spring to scan all code in the dev.ranieri packages
@EntityScan(basePackages = "dev.ranieri.entities") // tell spring to scan my entities
@EnableJpaRepositories(basePackages = "dev.ranieri.repos")// tell spring where to find my repos
public class PleasantSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(PleasantSpringApplication.class, args);
	}

}
