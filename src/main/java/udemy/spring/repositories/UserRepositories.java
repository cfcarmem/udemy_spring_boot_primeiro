package udemy.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import udemy.spring.entities.Usuario;

public interface UserRepositories extends JpaRepository<Usuario, Long> {
	

}
