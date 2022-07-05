package udemy.spring.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import udemy.spring.entities.Order;
import udemy.spring.services.OrderServices;

@RestController
@RequestMapping("/orders")
public class OrderResource {
	//injeção de dependencia
	
	@Autowired
	private OrderServices service;
	
	@GetMapping
	public ResponseEntity<List<Order>> findAll(){
		List<Order> lista = service.findAll();
		//Usuario u = new Usuario(3L, "Maria", "gg@gmail.com", "1111","99999");
		//return ResponseEntity.ok(u);
		return ResponseEntity.ok().body(lista);
	}

	@GetMapping(value="/{id}")
	public ResponseEntity<Order> findbyId(@PathVariable Long id){
		Order obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
