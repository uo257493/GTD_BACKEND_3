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
	
	@Column(name="status_accept")
	private boolean statusAccept;
	
	@ManyToOne
	@JoinColumn (name="id_user")
	private Users users;
	
	@ManyToOne
	@JoinColumn (name="id_group")
	private Groups groups;
	
	
}
