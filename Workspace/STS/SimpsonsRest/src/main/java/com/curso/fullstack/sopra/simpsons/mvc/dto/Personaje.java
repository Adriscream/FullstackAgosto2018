package com.curso.fullstack.sopra.simpsons.mvc.dto;

import java.util.Set;

public class Personaje {
	private String id;
	private String name;
	private int age;
	private String parent;
	private String mother;
	private String married;

	private Set<String> brothers; // Set no acepta duplicado
	private Set<String> cousins;
	private Set<String> children;

	public Personaje() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Personaje(String id, String name, int age, String parent, String mother, Set<String> brothers,
			Set<String> cousins) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.parent = parent;
		this.mother = mother;
		this.brothers = brothers;
		this.cousins = cousins;
	}

	public Personaje(String id, String name, int age, String parent, String mother, String married,
			Set<String> brothers, Set<String> cousins, Set<String> children) {
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

	public String getParent() {
		return parent;
	}

	public void setParent(String parent) {
		this.parent = parent;
	}

	public String getMother() {
		return mother;
	}

	public void setMother(String mother) {
		this.mother = mother;
	}

	public String getMarried() {
		return married;
	}

	public void setMarried(String married) {
		this.married = married;
	}

	public Set<String> getBrothers() {
		return brothers;
	}

	public void setBrothers(Set<String> brothers) {
		this.brothers = brothers;
	}

	public Set<String> getCousins() {
		return cousins;
	}

	public void setCousins(Set<String> cousins) {
		this.cousins = cousins;
	}

	public Set<String> getChildren() {
		return children;
	}

	public void setChildren(Set<String> children) {
		this.children = children;
	}

	public void addBrothers(String bro) {
		this.cousins.add(bro);
	}

	public void addCousins(String cousins) {
		this.cousins.add(cousins);
	}

	public void addChildren(String children) {
		this.cousins.add(children);
	}

}
