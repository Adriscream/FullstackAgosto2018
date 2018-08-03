package com.curso.fullstack.sopra.mvc.persistance;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso.fullstack.sopra.mvc.dto.Persona;

/*
 * JpaRepository<T, ID> 
 * T es la entidad y es el dato que vamos a tratar. 
 * ID es el tipo del ID o de la clave primaria.
 * Los tipos que definamos tienen que ser tipos manejados por JPA, esto se hace poniendo @Entity en el bean del objeto y @Id 
 */
public interface PersonaRepository extends JpaRepository<Persona, Long> {// Los generics no aceptan tipos primitivos
																			// long (referencia) , Long es un wrapper o
																			// envoltorio y son los que aceptan los
																			// generic

}
