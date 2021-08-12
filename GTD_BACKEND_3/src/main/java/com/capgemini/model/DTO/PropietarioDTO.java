package com.capgemini.model.DTO;

import java.sql.Date;
import java.util.List;

import com.capgemini.model.GroupUsers;

public class PropietarioDTO {

	public Long id;
	public String type;
	public String email;
	public boolean isAdmin;
	public String login;
	public String password;
	public String status;
	public String password2;
	public Long idCategorias;
	public Long idTasks;
	public List<GroupUsers> groupUsers;
	public String nombre;
	public String descripcion;
	public boolean Admin;
	public Date fechaCreacion;

}
