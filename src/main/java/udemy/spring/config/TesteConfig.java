package udemy.spring.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import udemy.spring.entities.Usuario;
import udemy.spring.repositories.UserRepositories;

@Configuration
@Profile("test") //o nome test é o mesmo do properties test
//esse teste vamos popular o banco de dados
public class TesteConfig  implements CommandLineRunner{
	@Autowired   //dando uma injeção de dependência. Associa uma instância de UserRepositeires aqui
	private UserRepositories userRepo;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Usuario u1 = new Usuario(null, "Maria Brown", "maria@gmail.com", "988888888", "123456"); 
		Usuario u2 = new Usuario(null, "Alex Green", "alex@gmail.com", "977777777", "123456"); 
		userRepo.saveAll(Arrays.asList(u1,u2));
		
		
	}
	
	
	
	
	

}
