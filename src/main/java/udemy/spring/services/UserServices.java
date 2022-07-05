package udemy.spring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import udemy.spring.entities.Usuario;
import udemy.spring.repositories.UserRepositories;

@Service  //ESSE É O REGISTR DO COMPONENTE POIS ELE TEM DEPENDENTE OU SEJA, ALGUMA CLASSE DÁ AUTOWIRED NELE
public class UserServices {
	
	@Autowired
	private UserRepositories repo;
	
	public List<Usuario> findAll(){
		return repo.findAll();
	}
	
	public Usuario findById(Long id) {
		//usar o Option da classe Optional para retornar 
		 Optional<Usuario> obj = repo.findById(id);
		 return obj.get();
	}

}
