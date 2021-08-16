package com.capgemini.model.DTO;

import java.sql.Date;
import java.util.List;

import com.capgemini.model.GroupUsers;
import com.capgemini.model.Users;

public class PropietarioDTO {

	public Long id;
	public String type = "usuario";
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
	public Date fechaCreacion;
	public Users usuarioPropietario;

}
