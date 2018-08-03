package com.curso.fullstack.sopra.banca.mvc.persistance;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;

import com.curso.fullstack.sopra.banca.mvc.dto.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, String>, QuerydslPredicateExecutor<Cliente>{

	
	List<Cliente> findByName(String name);
	
	//[SQL] SELCT P.* FROM CLIENTE AS P WHERE ID = ?
	//[SQL] SELCT * FROM CLIENTE WHERE ID = ?
	@Query("select c from Cliente c where c.name = :name")//JPQL lenguaje propio de JPA que utiliza los nombres de los atributos de las clases y las clases, en lugar de los de las tablas de la BBDD
	List<Cliente> buscarPorName(@Param("name") String name);
}