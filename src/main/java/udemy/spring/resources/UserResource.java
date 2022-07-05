package udemy.spring.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import udemy.spring.entities.Usuario;

@RestController
@RequestMapping("/users")
public class UserResource {
	
	@GetMapping
	public ResponseEntity<Usuario> findAll(){
		Usuario u = new Usuario(3L, "Maria", "gg@gmail.com", "1111","99999");
		return ResponseEntity.ok(u);
		
	}

}
