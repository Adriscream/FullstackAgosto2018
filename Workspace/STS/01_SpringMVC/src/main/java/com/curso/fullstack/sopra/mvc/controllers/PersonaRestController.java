package com.curso.fullstack.sopra.mvc.controllers;

import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curso.fullstack.sopra.mvc.bussines.PersonasServicio;
import com.curso.fullstack.sopra.mvc.controllers.util.HttpHeadersUtil;
import com.curso.fullstack.sopra.mvc.dto.Mensaje;
import com.curso.fullstack.sopra.mvc.dto.Persona;

@RestController
@RequestMapping("/personas") // Identificamos el recurso con el que trabajamos en este servicio
//@Controller //Se puede utilizar junto con response Body como equivalente a RestController, es menos eficiente
public class PersonaRestController {
	
	@Autowired
	private PersonasServicio personasServicio; 
	@Autowired
	private HttpHeadersUtil httpHeadersUtil;
//@ResponseBody
	@GetMapping("/{id}") // id es una clave primaria, y tiene que ser unica siempre.
	public ResponseEntity<Persona> get(@PathVariable long id) { // Busqueda de persona por id, tipo consulta del CRUD,
																// como no indicamos el @PathVariable (name=), la
																// variable long se tiene que llamar como la que hemos
								// puesto en el path
		//Version anterior se ponia el nombre , @RequestParam(name="nombre", required=false, defaultValue="World") String nombre
		return new ResponseEntity<Persona>(personasServicio.getPersonaById(id), HttpStatus.OK);
	}

	@GetMapping // No hace falta especificar el path puesto que no hay dos metodos que se llamen
				// igual y que tengan el mismo path
	public ResponseEntity<List<Persona>> get() { // Lista de persona es un get de consulta
		return new ResponseEntity<List<Persona>>(personasServicio.getPersonas(), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Void> alta(@RequestBody Persona persona) { // Dar de alta a persona puede ser un PUT si es
																		// generada la
		// primaryKey en el lado del cliente y POST si se autogenera aqui
		HttpHeaders headers = new HttpHeaders(); // Existen un monton de cabeceras, aqui esta vacia
		try {
			long id = personasServicio.nuevaPersona(persona);
			httpHeadersUtil.addHeaderLocation(headers, id);
			return new ResponseEntity<>(headers, HttpStatus.CREATED); // Retornamos una respuesta con el codigo de
																		// status de created y una cabecera

		} catch (URISyntaxException e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // Retornamos una respuesta con el codigo de
																			// status de error, no haria falta que
																			// hicieramos esto porque es el que se lanza
																			// por defecto, podriamos propagar el error
																			// con un throws URISyntaxException
		}
	}
	// ResponseEntity<T> es un tipo generic, Se encarga de autogenerar la respuesta
	// metiendo los datos que queremos en el body o cuerpo de la misma

	@DeleteMapping("/{id}")
	public ResponseEntity<Mensaje> delete(@PathVariable long id) {
		personasServicio.borrarPersona(id);
		return new ResponseEntity<Mensaje>(new Mensaje("Se ha borrado el registro con id:" + id + "."), HttpStatus.OK);
	}
}
