package com.curso.fullstack.sopra.banca.mvc.bussines;

import java.util.List;

import com.curso.fullstack.sopra.banca.mvc.dto.Cliente;

public interface ClientesServicio {

	Cliente getClienteById(String id);

	List<Cliente> getClientes();

	String nuevaCliente(Cliente cliente);

	void borrarCliente(String id);

	String actualizarClave(Cliente cliente);

	Cliente getClienteByName(String name);

}
