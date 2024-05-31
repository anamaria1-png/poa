package com.example.poa;

import com.example.poa.service.AplicatieService;
import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PoaApplication {
	private final AplicatieService aplicatieService;

	public PoaApplication(AplicatieService aplicatieService) {
		this.aplicatieService = aplicatieService;
	}

	public static void main(String[] args) {
		SpringApplication.run(PoaApplication.class, args);
	}

	@PostConstruct
	private void runAfterObjectCreated() {
		aplicatieService.adaugaDateInitiale();
	}
}
