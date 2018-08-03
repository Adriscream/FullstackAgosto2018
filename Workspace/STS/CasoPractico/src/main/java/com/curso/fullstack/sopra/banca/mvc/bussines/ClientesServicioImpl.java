package com.curso.fullstack.sopra.banca.mvc.bussines;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.fullstack.sopra.banca.mvc.dto.Cliente;
import com.curso.fullstack.sopra.banca.mvc.dto.QCliente;
import com.curso.fullstack.sopra.banca.mvc.persistance.ClienteRepository;

@Service
public class ClientesServicioImpl implements ClientesServicio {

	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private GenerateCC generateCC;
	
	@Override
	public Cliente getClienteById(String id) {
		return clienteRepository.findById(id).get();
		}

	@Override
	public List<Cliente> getClientes() {
		return clienteRepository.findAll();
	}
	
	@Override
	public Cliente getClienteByName(String name) {
		return clienteRepository.findOne(QCliente.cliente.name.eq(name)).get();
		}
	
	@Override
	public String nuevaCliente(Cliente cliente) {
		generateCC.generateCC(cliente);
		cliente = clienteRepository.saveAndFlush(cliente);							
		//Aqui se realizaria el envio de un mail
		return cliente.getCuentaCorriente();
	}

	@Override
	public void borrarCliente(String id) {
		clienteRepository.deleteById(id);
	}

	@Override
	public String actualizarClave(Cliente cliente) {
		// TODO Auto-generated method stub
		return null;
	}
}