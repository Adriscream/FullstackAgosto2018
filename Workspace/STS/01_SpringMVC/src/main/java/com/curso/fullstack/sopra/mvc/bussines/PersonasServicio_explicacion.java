package com.curso.fullstack.sopra.mvc.bussines;

import org.springframework.stereotype.Service;

import com.curso.fullstack.sopra.mvc.dto.Persona;
	
 
//@Component
@Service
//@Repository
//@Configuration
//@Controller
public class PersonasServicio_explicacion {
	// Se compromete a realizar un trabajo, en este caso darme una persona partiendo
	// de su id
	public static Persona getPersonaById(long id) {
		return new Persona(id);
	}
}
