package org.certificatic.spring.mvc.digestsecurity.practica34.repository.impl;

import java.util.Arrays;
import java.util.Hashtable;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.certificatic.spring.mvc.digestsecurity.practica34.repository.UserDetailsRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

// Analiza clase HardcodedUserDetailsRepository
public class HardcodedUserDetailsRepository implements UserDetailsRepository {

	private static final Map<String, UserDetails> users = new Hashtable<>();

	static {
		users.put("admin", buildUser("admin", "admin", "ROLE_ADMIN"));
		users.put("xvanhalenx", buildUser("xvanhalenx", "123123", "ROLE_ROOT", "ROLE_ADMIN"));
		users.put("user", buildUser("user", "user", "ROLE_USER"));
	}

	@Override
	public UserDetails findByUsername(String username) {
		UserDetails user = Optional.of(cloneUser(username))
				.orElseThrow(() -> new UsernameNotFoundException("Username not found"));

		return user;
	}

	private UserDetails cloneUser(String username) {
		UserDetails userInMap = users.get(username);
		if (userInMap != null)
			return new User(userInMap.getUsername(), userInMap.getPassword(), userInMap.getAuthorities());
		return null;
	}

	private static UserDetails buildUser(String username, String password, String... authorities) {
		return new User(username, password, Arrays.asList(authorities).stream()
				.map(auth -> new SimpleGrantedAuthority(auth)).collect(Collectors.toList()));
	}

}
