package com.br.api.clientes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ClientesApplication {
 
//	@Bean
//	public CommandLineRunner run(@Autowired ClienteRepository repository) {
//		return args -> {
//			Cliente cliente = Cliente.builder().cpf("00000000000").nome("Fulano").build();
//			repository.save(cliente);
//		};
//		
//	}
	
	public static void main(String[] args) {
				
		SpringApplication.run(ClientesApplication.class, args);
			
	}

}
