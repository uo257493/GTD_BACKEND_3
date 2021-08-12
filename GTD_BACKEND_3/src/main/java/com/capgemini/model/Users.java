package com.capgemini.model;


import java.util.Objects;


import javax.persistence.Column;
import javax.persistence.Entity;

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
	public Users(Long id, String type, String email, boolean isAdmin, String login, String password, String status,
			String password2) {
		super(id, type);
		this.email = email;
		this.isAdmin = isAdmin;
		this.login = login;
		this.password = password;
		this.status = status;
		this.password2 = password2;
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, isAdmin, login, password, status);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Users other = (Users) obj;
		return Objects.equals(email, other.email) && isAdmin == other.isAdmin
				&& Objects.equals(login, other.login) && Objects.equals(password, other.password)
				&& Objects.equals(status, other.status);
	}

	@Override
	public String toString() {
		return "usersVO [email=" + email + ", isAdmin=" + isAdmin + ", login=" + login + ", password="
				+ password + ", status=" + status + "]";
	}
}
