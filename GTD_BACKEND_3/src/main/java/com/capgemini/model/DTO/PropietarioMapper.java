package com.capgemini.model.DTO;

import com.capgemini.model.Propietario;
import com.capgemini.model.Users;

public class PropietarioMapper {

	public static Propietario executed(PropietarioDTO propietariodto) {
	if(propietariodto.type.equals("usuario")){
		Users usu1  = new Users(propietariodto.id,propietariodto.type,propietariodto.email,propietariodto.isAdmin, propietariodto.login, propietariodto.password, propietariodto.status, propietariodto.password2);
		return usu1;
	}
	return null;
		
		
	}
}
