package udemy.spring.services;

import java.util.List;
import java.util.Optional;

import javax.swing.text.html.Option;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
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
	
	//adicionando usuário
	public Usuario insert(Usuario obj) {
		return repo.save(obj);
	}
	
	
	//deleçao
	public void delete(Long id) {
	  repo.deleteById(id);
	}
	
	//atualização
	public Usuario update(Long id, Usuario user) {
	   Optional<Usuario> obj = repo.findById(id);
		updateDados(obj,user);
		return repo.save(obj.get());
		
	}
	
	private void updateDados(Optional<Usuario> entity, Usuario obj) {
		entity.get().setName(obj.getName());
		entity.get().setFone(obj.getFone());
		entity.get().setEmail(obj.getEmail());
		
	}

}
