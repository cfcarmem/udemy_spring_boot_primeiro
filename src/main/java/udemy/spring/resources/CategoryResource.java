package udemy.spring.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import udemy.spring.entities.Category;
import udemy.spring.entities.Usuario;
import udemy.spring.services.CategoryServices;

@RestController
@RequestMapping("/categories")
public class CategoryResource {
	
	@Autowired
	private CategoryServices service;
	
	public ResponseEntity<List<Category>> findAll(){
		List<Category> lista = service.findAll();
		return ResponseEntity.ok().body(lista);
	}
	
	@GetMapping(value="/{id}")
	public  ResponseEntity<Category> findId(@PathVariable Long id) {
		Category obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	

}
