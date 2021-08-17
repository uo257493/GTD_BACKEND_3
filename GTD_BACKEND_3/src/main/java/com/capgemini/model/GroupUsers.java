package com.capgemini.model;


import javax.persistence.CascadeType;
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
	
	@Column(name="status_accept")
	private boolean statusAccept;
	

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn (name="id_user")
	private Users users;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn (name="id_group")
	private Groups groups;
	
	@Column(name="is_admin")
	private boolean isAdmin;

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

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public GroupUsers(int idGroupUser, boolean statusAccept, Users users, Groups groups, boolean isAdmin) {
		super();
		this.idGroupUser = idGroupUser;
		this.statusAccept = statusAccept;
		this.users = users;
		this.groups = groups;
		this.isAdmin = isAdmin;
	}

	public GroupUsers() {
	}

	@Override
	public String toString() {
		return "GroupUsers [idGroupUser=" + idGroupUser + ", statusAccept=" + statusAccept + ", users=" + users
				+ ", groups=" + groups + ", isAdmin=" + isAdmin + "]";
	}
	
}
