package pl.piomin.samples.springboot.kubernetes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

// Adding a comment to trigger a build
@SpringBootApplication
@EnableMongoRepositories
public class SpringBootOnKubernetesApp {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootOnKubernetesApp.class, args);
	}

}
