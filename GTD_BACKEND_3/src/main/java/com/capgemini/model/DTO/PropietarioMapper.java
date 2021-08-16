package com.capgemini.model.DTO;

import com.capgemini.model.Groups;
import com.capgemini.model.Propietario;
import com.capgemini.model.Users;

public class PropietarioMapper {

	public static Propietario executed(PropietarioDTO propietariodto) {
	if(propietariodto.type.equals("usuario")){
		Users usu1  = new Users(propietariodto.id,propietariodto.type,propietariodto.email,propietariodto.isAdmin, propietariodto.login, propietariodto.password, propietariodto.status, propietariodto.groupUsers);
		return usu1;
	}else if(propietariodto.type.equals("grupo")) {
		Groups grupo1 = new Groups(propietariodto.id, propietariodto.type,propietariodto.nombre,propietariodto.descripcion,propietariodto.fechaCreacion,propietariodto.usuarioPropietario, propietariodto.groupUsers);
		
		return grupo1;
	}
	return null;
		
		
	}
	
	public static Propietario execu(PropietarioDTO propietariodto) {
		if(propietariodto.isAdmin ){
			Groups grupo1 = new Groups(propietariodto.id, propietariodto.type,propietariodto.nombre,propietariodto.descripcion,propietariodto.fechaCreacion,propietariodto.usuarioPropietario, propietariodto.groupUsers);
			return grupo1;
		}else {
			Groups grupo1 = new Groups(propietariodto.id, propietariodto.type,propietariodto.nombre,propietariodto.descripcion,propietariodto.fechaCreacion,propietariodto.usuarioPropietario, propietariodto.groupUsers);
			return grupo1;
		}
		
	}
}
