package com.curso.fullstack.sopra.simpsons.mvc.dto;

import java.util.Set;

public class PersonajeShit {
	private String id;
	private String name;
	private int age;
	private PersonajeShit parent;
	private PersonajeShit mother;
	private PersonajeShit married;

	private Set<PersonajeShit> brothers; // Set no acepta duplicado
	private Set<PersonajeShit> cousins;
	private Set<PersonajeShit> children;

	public PersonajeShit() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PersonajeShit(String id, String name, int age, PersonajeShit parent, PersonajeShit mother, Set<PersonajeShit> brothers,
			Set<PersonajeShit> cousins) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.parent = parent;
		this.mother = mother;
		this.brothers = brothers;
		this.cousins = cousins;
	}

	public PersonajeShit(String id, String name, int age, PersonajeShit parent, PersonajeShit mother, PersonajeShit married,
			Set<PersonajeShit> brothers, Set<PersonajeShit> cousins, Set<PersonajeShit> children) {
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

	public PersonajeShit getParent() {
		return parent;
	}

	public void setParent(PersonajeShit parent) {
		this.parent = parent;
	}

	public PersonajeShit getMother() {
		return mother;
	}

	public void setMother(PersonajeShit mother) {
		this.mother = mother;
	}

	public PersonajeShit getMarried() {
		return married;
	}

	public void setMarried(PersonajeShit married) {
		this.married = married;
	}

	public Set<PersonajeShit> getBrothers() {
		return brothers;
	}

	public void setBrothers(Set<PersonajeShit> brothers) {
		this.brothers = brothers;
	}

	public Set<PersonajeShit> getCousins() {
		return cousins;
	}

	public void setCousins(Set<PersonajeShit> cousins) {
		this.cousins = cousins;
	}

	public Set<PersonajeShit> getChildren() {
		return children;
	}

	public void setChildren(Set<PersonajeShit> children) {
		this.children = children;
	}

	public void addBrothers(PersonajeShit bro) {
		this.cousins.add(bro);
	}

	public void addCousins(PersonajeShit cousins) {
		this.cousins.add(cousins);
	}

	public void addChildren(PersonajeShit children) {
		this.cousins.add(children);
	}

}
