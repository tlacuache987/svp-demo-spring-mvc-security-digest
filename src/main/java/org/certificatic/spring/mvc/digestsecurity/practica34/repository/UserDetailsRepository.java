package org.certificatic.spring.mvc.digestsecurity.practica34.repository;

import org.springframework.security.core.userdetails.UserDetails;

// Analiza interface UserDetailsRepository
public interface UserDetailsRepository {

	public UserDetails findByUsername(String username);

}
