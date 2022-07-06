package udemy.spring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import udemy.spring.entities.Category;
import udemy.spring.repositories.CategoryRepositories;

@Service
public class CategoryServices {
	@Autowired 
	private CategoryRepositories repo;
	
	public List<Category> findAll(){
		List<Category> lista = repo.findAll();
		return lista;
	}
	
	
	public  Category findById(Long id){
		 Optional<Category> obj = repo.findById(id);
		 return obj.get();
	}

}
