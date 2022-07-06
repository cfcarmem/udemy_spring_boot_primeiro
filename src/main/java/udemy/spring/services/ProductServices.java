package udemy.spring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import udemy.spring.entities.Product;
import udemy.spring.repositories.ProductRepositories;

@Service  //ESSE É O REGISTR DO COMPONENTE POIS ELE TEM DEPENDENTE OU SEJA, ALGUMA CLASSE DÁ AUTOWIRED NELE
public class ProductServices {
	
	@Autowired
	private ProductRepositories repo;
	
	public List<Product> findAll(){
		return repo.findAll();
	}
	
	public Product findById(Long id) {
		//usar o Option da classe Optional para retornar 
		 Optional<Product> obj = repo.findById(id);
		 return obj.get();
	}

}
