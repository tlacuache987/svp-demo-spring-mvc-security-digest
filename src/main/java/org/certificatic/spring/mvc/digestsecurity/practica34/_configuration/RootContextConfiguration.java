package org.certificatic.spring.mvc.digestsecurity.practica34._configuration;

import org.certificatic.spring.mvc.digestsecurity.practica34.repository.impl.HardcodedUserDetailsRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // Esta clase de configuracion sirve para definir beans del RootApplicationContext
public class RootContextConfiguration {
	
	// Define bean HardcodedUserDetailsRepository
	@Bean
	public HardcodedUserDetailsRepository hardcodedUserDetailsRepository() {
		return new HardcodedUserDetailsRepository();
	}
	
}