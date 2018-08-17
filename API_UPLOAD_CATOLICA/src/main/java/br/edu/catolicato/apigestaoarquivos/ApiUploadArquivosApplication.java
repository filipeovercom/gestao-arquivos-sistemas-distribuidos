package br.edu.catolicato.apigestaoarquivos;

import br.edu.catolicato.apigestaoarquivos.storage.StorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ApiUploadArquivosApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiUploadArquivosApplication.class, args);
	}

	@Bean
	CommandLineRunner init(StorageService storageService) {
		return (args) -> {
			storageService.deleteAll();
			storageService.init();
		};
	}
}
