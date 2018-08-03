package com.curso.fullstack.sopra.mvc;

import javax.servlet.Servlet;

import org.h2.server.web.WebServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class H2Configuration {
	@Bean// Crea un Bean con este metodo para que pueda ser referenciado con @Autowired 
	ServletRegistrationBean<Servlet> h2servletRegistration() {
		ServletRegistrationBean<Servlet> registrationBean = new ServletRegistrationBean<Servlet>(new WebServlet(), "/console/*");
		return registrationBean;
		/*
		 * WebServlet() es el Bean que queremos registrar y es un Servlet de H2
		 */
	}
	
	//Ejemplo
//	@Bean
//	List<Persona> misPersonas(){
//		return new ArrayList<>();
//		
//	}
}
