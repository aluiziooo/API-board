package br.com.apitabuleiro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.apitabuleiro.utils.utils;

@SpringBootApplication
public class ApiTabuleiroApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiTabuleiroApplication.class, args);
		utils u = new utils();
		
		String retorno = u.bestLance("%20xo%20o%20%20%20%20");
		System.out.println(retorno);
	}

}
