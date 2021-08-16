package com.capgemini.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

import org.springframework.data.rest.core.annotation.RestResource;


import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
//@RestResource(rel="propietario", path="propietario")
@Inheritance(strategy=InheritanceType.JOINED)
public class Propietario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	public String type;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Propietario(Long id, String type) {
		super();
		this.id = id;
		this.type = type;
	}


	@OneToMany(mappedBy = "propietario", cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<Categories> categories;

	@OneToMany(mappedBy = "propietario", cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<Tasks> tasks;
	
	
	public List<Categories> getCategories() {
		return categories;
	}

	public void setCategories(List<Categories> categories) {
		this.categories = categories;
	}

	public List<Tasks> getTasks() {
		return tasks;
	}

	public void setTasks(List<Tasks> tasks) {
		this.tasks = tasks;
	}

	@Override
	public String toString() {
		return "Propietario [id=" + id + ", type=" + type + ", categories=" + categories + ", tasks=" + tasks + "]";
	}

	public Propietario(Long id, String type, List<Categories> categories, List<Tasks> tasks) {
		super();
		this.id = id;
		this.type = type;
		this.categories = categories;
		this.tasks = tasks;
	}

	public Propietario(String type, List<Categories> categories, List<Tasks> tasks) {
		super();
		this.type = type;
		this.categories = categories;
		this.tasks = tasks;
	}

	public Propietario() {
		super();
	}
	
	
	
}
