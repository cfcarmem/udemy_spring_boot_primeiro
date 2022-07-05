package udemy.spring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import udemy.spring.entities.Order;
import udemy.spring.entities.Usuario;
import udemy.spring.repositories.OrderRepositories;

@Service  //ESSE É O REGISTR DO COMPONENTE POIS ELE TEM DEPENDENTE OU SEJA, ALGUMA CLASSE DÁ AUTOWIRED NELE
public class OrderServices {
	
	@Autowired
	private OrderRepositories repo;
	
	public List<Order> findAll(){
		return repo.findAll();
	}
	
	public Order findById(Long id) {
		//usar o Option da classe Optional para retornar 
		 Optional<Order> obj = repo.findById(id);
		 return obj.get();
	}

}
