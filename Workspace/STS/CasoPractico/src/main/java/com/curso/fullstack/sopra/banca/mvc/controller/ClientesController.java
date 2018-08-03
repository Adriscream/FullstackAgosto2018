package com.curso.fullstack.sopra.banca.mvc.controller;

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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curso.fullstack.sopra.banca.mvc.bussines.ClientesServicio;
import com.curso.fullstack.sopra.banca.mvc.controller.util.HttpHeadersUtil;
import com.curso.fullstack.sopra.banca.mvc.dto.Cliente;
import com.curso.fullstack.sopra.banca.mvc.dto.Mensaje;

@RestController
@RequestMapping("/clientes")
public class ClientesController {
	//1. Usando example en findby
	//3.@Query("select c from Cliente c where c.name = :name")//consulta JPQL, basado en clases, no en tablas, los nombres son los de la clase
	//2.List<Cliente> findByName(@Param("name") String name);
	//4.QueryDSLotra forma.
	
	@Autowired
	private ClientesServicio clientesServicio; 
	@Autowired
	private HttpHeadersUtil httpHeadersUtil;
	
	@GetMapping("/{id}") 
	public ResponseEntity<Cliente> get(@PathVariable String id) { 
		return new ResponseEntity<Cliente>(clientesServicio.getClienteById(id), HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<Cliente>> get() {
		return new ResponseEntity<List<Cliente>>(clientesServicio.getClientes(), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Void> alta(@RequestBody Cliente cliente) { 
		HttpHeaders headers = new HttpHeaders(); 
		try {
			String id = clientesServicio.nuevaCliente(cliente);
			httpHeadersUtil.addHeaderLocation(headers, id);
			return new ResponseEntity<>(headers, HttpStatus.CREATED); 
		} catch (URISyntaxException e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping
	public ResponseEntity<Void> update(@RequestBody Cliente cliente) { 
		HttpHeaders headers = new HttpHeaders(); 
		try {
			String id = clientesServicio.actualizarClave(cliente);
			httpHeadersUtil.addHeaderLocation(headers, id);
			return new ResponseEntity<>(headers, HttpStatus.CREATED); 
		} catch (URISyntaxException e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Mensaje> delete(@PathVariable String id) {
		clientesServicio.borrarCliente(id);
		return new ResponseEntity<Mensaje>(new Mensaje("Se ha borrado el registro con id:" + id + "."), HttpStatus.OK);
	}
}
