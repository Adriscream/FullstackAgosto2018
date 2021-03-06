package com.curso.fullstack.sopra.simpsons.mvc.controllers;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashSet;
import java.util.Set;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curso.fullstack.sopra.simpsons.mvc.dto.Mensaje;
import com.curso.fullstack.sopra.simpsons.mvc.dto.Personaje;

@RestController
@RequestMapping("/simpsons/characters")
public class PersonajeRestController {

	@GetMapping("/{id}")
	public ResponseEntity<Personaje> get(@PathVariable String id) {
		Set<String> cousins = new HashSet<String>();
		cousins.add("Ling");
		Set<String> brothers = new HashSet<String>();
		brothers.add("Lisa");
		brothers.add("Maggie");
		
		
		
		String name = new String("Bartholomew Simpson");
		int age = 10;

		
		Personaje Homer = new Personaje("Homer", "Homer Simpson", 38, "Abraham Simpson", "Shit Smart", brothers, cousins);
		Personaje Marge = new Personaje("Marge", "Marge Crazy", 38, "Marge Doll", "Pussy Cat", brothers, cousins);
		
		String parent = Homer.getName();
		String mother = Marge.getName();
		
		Personaje Bart = new Personaje(id, name, age, parent, mother, brothers, cousins);

		return new ResponseEntity<Personaje>(Bart,HttpStatus.OK);
	}
	@GetMapping("/{id}/Brothers")
	public ResponseEntity<Set<Personaje>> getBrothers(@PathVariable String id) {
		Set<String> cousins = new HashSet<String>();
		cousins.add("Ling");
		Set<String> brothers = new HashSet<String>();
		brothers.add("Lisa");
		brothers.add("Maggie");

		String name = new String("Bartholomew Simpson");
		int age = 10;

		
		Personaje Homer = new Personaje("Homer", "Homer Simpson", 38, "Abraham Simpson", "Shit Smart", brothers, cousins);
		Personaje Marge = new Personaje("Marge", "Marge Crazy", 38, "Marge Doll", "Pussy Cat", brothers, cousins);
		Personaje Lisa = new Personaje("Lisa", "Lisa Simpson", 16, "homer Simpson", "Shit Smart", brothers, cousins);
		Personaje Maggie = new Personaje("Maggie", "Maggie Simpson", 6, "Marge Doll", "Pussy Cat", brothers, cousins);
		
		String parent = Homer.getName();
		String mother = Marge.getName();
		
		Personaje Bart = new Personaje(id, name, age, parent, mother, brothers, cousins);
		Set<Personaje> set = new HashSet<Personaje>();
		set.add(Lisa);
		set.add(Maggie);
		return new ResponseEntity<Set<Personaje>>(set,HttpStatus.OK);
	}
	@PostMapping
	public ResponseEntity<Void> alta(@RequestBody Personaje personaje) {
		HttpHeaders headers = new HttpHeaders();
		try {
			headers.setLocation(new URI("http:localhost:8080/simpsons/characters"));
			return new ResponseEntity<Void>(headers,HttpStatus.CREATED);
		} catch (URISyntaxException e) {
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping
	public ResponseEntity<Void> modificar(@RequestBody Personaje personaje) {
		HttpHeaders headers = new HttpHeaders();
		try {
			headers.setLocation(new URI("http:localhost:8080/simpsons/characters"));
			return new ResponseEntity<Void>(headers,HttpStatus.CREATED);
		} catch (URISyntaxException e) {
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Mensaje> delete(@PathVariable String id) {
		return new ResponseEntity<Mensaje>(new Mensaje(id + " al carrer"), HttpStatus.OK);
	}
}
