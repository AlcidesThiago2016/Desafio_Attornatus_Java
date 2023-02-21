package com.attornatus.gerenciadorDePessoas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@SpringBootApplication
@RestController
public class GerenciadorDePessoasApplication {

	public static void main(String[] args) {
		SpringApplication.run(GerenciadorDePessoasApplication.class, args);
	}

}
