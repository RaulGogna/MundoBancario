package es.eoi.mundoBancario;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableAutoConfiguration
@EnableJpaRepositories
public class MundoBancarioRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(MundoBancarioRestApplication.class, args);
	}

}
