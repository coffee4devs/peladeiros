package br.com.coffeefordevs.peladeiros;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Peladeiros API", version = "1.0", description = "Documentação da API do app."))
public class PeladeirosApplication {

	public static void main(String[] args) {
		SpringApplication.run(PeladeirosApplication.class, args);
	}

}
