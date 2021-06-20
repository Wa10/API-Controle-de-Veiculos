package com.desafio.controledeveiculos.controleveiculos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ControleveiculosApplication {
	public static void main(String[] args) {
		SpringApplication.run(ControleveiculosApplication.class, args);
	}

}
