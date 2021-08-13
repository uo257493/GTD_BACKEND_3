package com.capgemini.model;


import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table(name = "users")
public class Users extends Propietario{


	@Column(name = "email")
	private String email;

	@Column(name = "is_admin")
	private boolean isAdmin;

	@Column(name = "login")
	private String login;

	@Column(name = "password")
	private String password;

    private String status;
	
	@Transient
	private String password2;
	
	@OneToMany(mappedBy = "users", cascade = CascadeType.ALL)
	private List<GroupUsers> groupUsers;

	
	public void setPassword2(String password2) {
		this.password2 = password2;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public String getPassword2() {
		return password2;
	}
	
	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
	public Users(Long id, String type) {
		super(id, type);
	}

	public Users() {
		
	}

	public List<GroupUsers> getGroupUsers() {
		return groupUsers;
	}

	public void setGroupUsers(List<GroupUsers> groupUsers) {
		this.groupUsers = groupUsers;
	}

	@Override
	public String toString() {
		return "Users [email=" + email + ", isAdmin=" + isAdmin + ", login=" + login + ", password=" + password
				+ ", status=" + status + ", password2=" + password2 + ", groupUsers=" + groupUsers + "]";
	}

	public Users(Long id, String type, String email, boolean isAdmin, String login, String password, String status,
			String password2, List<GroupUsers> groupUsers) {
		super(id, type);
		this.email = email;
		this.isAdmin = isAdmin;
		this.login = login;
		this.password = password;
		this.status = status;
		this.password2 = password2;
		this.groupUsers = groupUsers;
	}




}