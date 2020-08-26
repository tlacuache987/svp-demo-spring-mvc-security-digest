package org.certificatic.spring.mvc.digestsecurity.practica34._dipatcherservletinitializer;

import org.certificatic.spring.mvc.digestsecurity.practica34._configuration.RootContextConfiguration;
import org.certificatic.spring.mvc.digestsecurity.practica34._configuration.SecurityContextConfiguration;
import org.certificatic.spring.mvc.digestsecurity.practica34._configuration.ServletContextConfiguration;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

//Extiende de AbstractAnnotationConfigDispatcherServletInitializer
public class SpringWebMvcDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	// Sobre escribe el metodo getRootConfigClasses
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { RootContextConfiguration.class, SecurityContextConfiguration.class };
	}

	// Sobre escribe el metodo getServletConfigClasses
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] { ServletContextConfiguration.class };
	}

	// Sobre escribe el metodo getServletMappings
	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}	

}