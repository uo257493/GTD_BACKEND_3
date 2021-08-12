package com.capgemini.model;

import java.util.Date;
import java.util.List;

import javax.persistence.ManyToMany;

public class Group {

	
	private String nombre;
	private String descripcion;
	private boolean Admin;
	private Date fechaCreacion;
	
	@ManyToOne(mappedBy = "group")
	private List<Users>users;
	
	
}
