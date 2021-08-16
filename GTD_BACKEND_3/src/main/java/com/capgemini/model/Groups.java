package com.capgemini.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Groups extends Propietario {

	private String nombre;
	private String descripcion;
	private boolean Admin;
	private Date fechaCreacion;

	@OneToMany(mappedBy = "groups", cascade = CascadeType.ALL)
	private List<GroupUsers> groupUsers;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public boolean isAdmin() {
		return Admin;
	}

	public void setAdmin(boolean admin) {
		Admin = admin;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public List<GroupUsers> getGroupUsers() {
		return groupUsers;
	}

	public void setGroupUsers(List<GroupUsers> groupUsers) {
		this.groupUsers = groupUsers;
	}

	@Override
	public String toString() {
		return "Groups [nombre=" + nombre + ", descripcion=" + descripcion + ", Admin=" + Admin + ", fechaCreacion="
				+ fechaCreacion + ", groupUsers=" + groupUsers + "]";
	}

	public Groups(Long id, String type, String nombre, String descripcion, boolean admin, Date fechaCreacion,
			List<GroupUsers> groupUsers) {
		super(id, type);
		this.nombre = nombre;
		this.descripcion = descripcion;
		Admin = admin;
		this.fechaCreacion = fechaCreacion;
		this.groupUsers = groupUsers;
	}

	public Groups(Long id, String type) {
		super(id, type);
	}

	public Groups() {

	}


}
