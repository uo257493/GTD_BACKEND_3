package com.capgemini.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "users")
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "email")
	private String email;

	@Column(name = "is_admin")
	private boolean isAdmin;

	@Column(name = "login")
	private String login;

	@Column(name = "password")
	private String password;

	@Column(name = "status")
	private String status;

	@Transient
	private String password2;

	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Categories> categories;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Tasks> tasks;

	public Users() {
	}

	public Users(String email, boolean isAdmin, String login, String password, String status) {
		this.email = email;
		this.isAdmin = isAdmin;
		this.login = login;
		this.password = password;
		this.status = status;
	}

	public Users(Long id, String email, boolean isAdmin, String login, String password, String status) {
		this.id = id;
		this.email = email;
		this.isAdmin = isAdmin;
		this.login = login;
		this.password = password;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public void addCategory(Categories category) {
		if (categories == null) {
			categories = new ArrayList<>();
		}
		categories.add(category);
		category.setUser(this);
	}

	public void addTask(Tasks task) {
		if (tasks == null) {
			tasks = new ArrayList<>();
		}
		tasks.add(task);
		task.setUser(this);
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, id, isAdmin, login, password, status);
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
		return Objects.equals(email, other.email) && Objects.equals(id, other.id) && isAdmin == other.isAdmin
				&& Objects.equals(login, other.login) && Objects.equals(password, other.password)
				&& Objects.equals(status, other.status);
	}

	@Override
	public String toString() {
		return "usersVO [id=" + id + ", email=" + email + ", isAdmin=" + isAdmin + ", login=" + login + ", password="
				+ password + ", status=" + status + "]";
	}
}
