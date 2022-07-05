package udemy.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import udemy.spring.entities.Usuario;

@Repository  //coloquei a annotation mas não precisaria pois já herda do JPA MAS É PARA REGISTRAR  POIS ALGUÉM DÁ AUTOWIRED NELA
public interface UserRepositories extends JpaRepository<Usuario, Long> {

	
}
