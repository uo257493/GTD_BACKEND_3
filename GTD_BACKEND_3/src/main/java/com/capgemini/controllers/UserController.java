package com.capgemini.controllers;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.model.GroupUsers;
import com.capgemini.model.Groups;
import com.capgemini.model.Propietario;
import com.capgemini.model.Users;
import com.capgemini.model.DTO.PropietarioDTO;
import com.capgemini.model.DTO.PropietarioMapper;
import com.capgemini.repositories.PropietarioRepository;
import com.capgemini.repositories.UserRepository;
import com.capgemini.service.UserService;



@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	UserRepository ur;
	
	@Autowired
	PropietarioRepository pr;

	@Autowired
	UserService us;
	
	
	@PostMapping("/add")
	public Propietario addPropietario(@RequestBody PropietarioDTO  propietario) {

		Propietario tr = pr.save(PropietarioMapper.executed(propietario));
		//Users us1 = us.getUserByid(session.getUsuario);
		Users us1 = new Users();
		us1.setId((long) 1);
		if(propietario.type.equals("grupo")) {
			us.save(new GroupUsers((Integer.parseInt(tr.getId()+"")),true,true,us1,(Groups)tr));
			return tr;
		}else {
			
		}
		return us1;
		
	//return pr.save(PropietarioMapper.executed(propietario));
	}	
	
	@PostMapping("/addgroup")
	public Propietario addGroup(@RequestBody PropietarioDTO propietario) {
		
		return pr.save(PropietarioMapper.execu(propietario));
	}
	
//	@GetMapping("/listUsers/{id}")
//	public List<Users> listUsers(@RequestAttribute Long id){
//		return us.ListUsusarios(id);
//	}
	
	@DeleteMapping("users/{id}")
    public String deteteUsers(@PathVariable Long id) {

        Optional<Propietario> propietario = pr.findById(id);

        if(propietario == null) {
            throw new RuntimeException("Id del propietario no encontrado -"+id);
        }

        pr.deleteById(id);
        
        return "Eliminado propietario id - "+id;
    }
	
	 @DeleteMapping("onlyUser/{id}")
	    public String deteteStudent(@PathVariable Long id) {

		  Optional<Users> propietario = us.findById(id);

	        if(propietario == null) {
	            throw new RuntimeException("Id del propietario no encontrado -"+id);
	        }

	        us.deleteById(id);
	        
	        return "Eliminado propietario id - "+id;
	    }
}
