package br.com.ufba.biblioteca;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



//@SpringBootApplication(exclude={SecurityAutoConfiguration.class})
@SpringBootApplication
public class BibliotecaUFBAApplication {

	public static void main(String[] args) {
		SpringApplication.run(BibliotecaUFBAApplication.class, args);
	}

}
