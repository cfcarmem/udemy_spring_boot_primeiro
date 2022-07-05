package udemy.spring.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import udemy.spring.entities.Usuario;
import udemy.spring.services.UserServices;

@RestController
@RequestMapping("/users")
public class UserResource {
	//injeção de dependencia
	
	@Autowired
	private UserServices service;
	
	@GetMapping
	public ResponseEntity<List<Usuario>> findAll(){
		List<Usuario> lista = service.findAll();
		//Usuario u = new Usuario(3L, "Maria", "gg@gmail.com", "1111","99999");
		//return ResponseEntity.ok(u);
		return ResponseEntity.ok().body(lista);
	}

	@GetMapping(value="/{id}")
	public ResponseEntity<Usuario> findbyId(@PathVariable Long id){
		Usuario obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
