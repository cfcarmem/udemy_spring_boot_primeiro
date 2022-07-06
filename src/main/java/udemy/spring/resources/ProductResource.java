package udemy.spring.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import udemy.spring.entities.Product;
import udemy.spring.services.ProductServices;

@RestController
@RequestMapping(value = "/produtos")
public class ProductResource {
	
	@Autowired
	private ProductServices service;
	
	@GetMapping
	public ResponseEntity<List<Product>> findAll(){
		List<Product> lista = service.findAll();
		return ResponseEntity.ok().body(lista);
	}
	
	@GetMapping(value="/{id}")
	public  ResponseEntity<Product> findId(@PathVariable Long id) {
		Product obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	
	

}
