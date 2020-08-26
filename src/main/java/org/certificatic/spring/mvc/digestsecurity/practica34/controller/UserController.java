package org.certificatic.spring.mvc.digestsecurity.practica34.controller;

import java.util.stream.Collectors;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController // Analiza User Controller
public class UserController {

	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public String user() {

		log.info("show user info ------------------");

		User principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		return "Welcome " + principal.getUsername() + " you're User. Assigned Roles: " + principal.getAuthorities()
				.stream().map(auth -> auth.getAuthority()).collect(Collectors.joining(", "));
	}

}
