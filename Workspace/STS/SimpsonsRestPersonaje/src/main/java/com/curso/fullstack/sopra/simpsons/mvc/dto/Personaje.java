package com.curso.fullstack.sopra.simpsons.mvc.dto;

import java.util.Set;

public class Personaje {
	private String id;
	private String name;
	private int age;
	private Personaje parent;
	private Personaje mother;
	private Personaje married;

	private Set<Personaje> brothers; // Set no acepta duplicado
	private Set<Personaje> cousins;
	private Set<Personaje> children;

	public Personaje(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Personaje() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Personaje(String id, String name, int age, Personaje parent, Personaje mother, Set<Personaje> brothers,
			Set<Personaje> cousins) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.parent = parent;
		this.mother = mother;
		this.brothers = brothers;
		this.cousins = cousins;
	}

	public Personaje(String id, String name, int age, Personaje parent, Personaje mother, Personaje married,
			Set<Personaje> brothers, Set<Personaje> cousins, Set<Personaje> children) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.parent = parent;
		this.mother = mother;
		this.married = married;
		this.brothers = brothers;
		this.cousins = cousins;
		this.children = children;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Personaje getParent() {
		return parent;
	}

	public void setParent(Personaje parent) {
		this.parent = parent;
	}

	public Personaje getMother() {
		return mother;
	}

	public void setMother(Personaje mother) {
		this.mother = mother;
	}

	public Personaje getMarried() {
		return married;
	}

	public void setMarried(Personaje married) {
		this.married = married;
	}

	public Set<Personaje> getBrothers() {
		return brothers;
	}

	public void setBrothers(Set<Personaje> brothers) {
		this.brothers = brothers;
	}

	public Set<Personaje> getCousins() {
		return cousins;
	}

	public void setCousins(Set<Personaje> cousins) {
		this.cousins = cousins;
	}

	public Set<Personaje> getChildren() {
		return children;
	}

	public void setChildren(Set<Personaje> children) {
		this.children = children;
	}

	public void addBrothers(Personaje bro) {
		this.cousins.add(bro);
	}

	public void addCousins(Personaje cousins) {
		this.cousins.add(cousins);
	}

	public void addChildren(Personaje children) {
		this.cousins.add(children);
	}

}
