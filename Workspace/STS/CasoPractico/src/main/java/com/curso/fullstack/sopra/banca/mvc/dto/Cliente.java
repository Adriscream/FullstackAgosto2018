package com.curso.fullstack.sopra.banca.mvc.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Cliente {
	@Id
	private String cuentaCorriente;
	@Column(nullable = false, unique = true)
	private String dni;
	private String name;
	private String password;
	@Column(nullable = false, unique = true)
	private String mail;
	private Double saldo;
	private boolean habilitado;

	public Cliente() {
		super();
	}

	public Cliente(String cuentaCorriente, String dni, String name, String password, String mail, Double saldo,
			boolean habilitado) {
		super();
		this.cuentaCorriente = cuentaCorriente;
		this.dni = dni;
		this.name = name;
		this.password = password;
		this.mail = mail;
		this.saldo = saldo;
		this.habilitado = habilitado;
	}

	public Cliente(String dni, String name, String password, String mail, boolean habilitado) {
		super();
		this.dni = dni;
		this.name = name;
		this.password = password;
		this.mail = mail;
		this.habilitado = habilitado;
	}

	public String getCuentaCorriente() {
		return cuentaCorriente;
	}

	public void setCuentaCorriente(String cuentaCorriente) {
		this.cuentaCorriente = cuentaCorriente;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public boolean isHabilitado() {
		return habilitado;
	}

	public void setHabilitado(boolean habilitado) {
		this.habilitado = habilitado;
	}
	
}
