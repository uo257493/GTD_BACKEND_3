package com.capgemini.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class GroupUsers {
	
	@Id
	@GeneratedValue
	private int idGroupUser;
	
	private boolean usuario;
	
	@Column(name="status_accept")
	private boolean statusAccept;
	
	@ManyToOne
	@JoinColumn (name="id_user")
	private Users users;
	
	@ManyToOne
	@JoinColumn (name="id_group")
	private Groups groups;

	public boolean isUsuario() {
		return usuario;
	}

	public void setUsuario(boolean usuario) {
		this.usuario = usuario;
	}

	public int getIdGroupUser() {
		return idGroupUser;
	}

	public void setIdGroupUser(int idGroupUser) {
		this.idGroupUser = idGroupUser;
	}

	public boolean isStatusAccept() {
		return statusAccept;
	}

	public void setStatusAccept(boolean statusAccept) {
		this.statusAccept = statusAccept;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public Groups getGroups() {
		return groups;
	}

	public void setGroups(Groups groups) {
		this.groups = groups;
	}


	public GroupUsers(int idGroupUser, boolean usuario, boolean statusAccept, Users users, Groups groups) {
		super();
		this.idGroupUser = idGroupUser;
		this.usuario = usuario;
		this.statusAccept = statusAccept;
		this.users = users;
		this.groups = groups;
	}

	@Override
	public String toString() {
		return "GroupUsers [idGroupUser=" + idGroupUser + ", usuario=" + usuario + ", statusAccept=" + statusAccept
				+ ", users=" + users + ", groups=" + groups + "]";
	}

	public GroupUsers() {
		super();
	}
	
	
}
