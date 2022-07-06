package udemy.spring.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	

	@PostMapping
	//na url é só colocar http://localhost:8080/users 
	/*
	 * 
	 * 
	 */
	public ResponseEntity<Usuario> insert(@RequestBody Usuario obj){
		//gerar o endereço de resposta 201
		URI uri  = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(service.insert(obj));
	}
	
	//endpoint para deletar
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Usuario>delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<Usuario> update(@PathVariable Long id, @RequestBody Usuario obj) {
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
	
	
}
