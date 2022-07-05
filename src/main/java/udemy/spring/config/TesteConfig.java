package udemy.spring.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import udemy.spring.entities.Order;
import udemy.spring.entities.Usuario;
import udemy.spring.repositories.OrderRepositories;
import udemy.spring.repositories.UserRepositories;

@Configuration
@Profile("test") //o nome test é o mesmo do properties test
//esse teste vamos popular o banco de dados
public class TesteConfig  implements CommandLineRunner{
	@Autowired   //dando uma injeção de dependência. Associa uma instância de UserRepositeires aqui
	private UserRepositories userRepo;
	
	@Autowired
	private OrderRepositories orderRepo;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Usuario u1 = new Usuario(null, "Carlos", "carlos@gmail.com", "988888888", "123456"); 
		Usuario u2 = new Usuario(null, "Paulo", "paulo@gmail.com", "977777777", "123456"); 
		userRepo.saveAll(Arrays.asList(u1,u2));
		
		//usando padrão UTC
		Order o1 = new Order(null, Instant.parse("2022-06-20T19:53:07Z"), u1); 
		Order o2 = new Order(null, Instant.parse("2022-07-21T03:42:10Z"), u2); 
		Order o3 = new Order(null, Instant.parse("2022-07-22T15:21:22Z"), u1);
		orderRepo.saveAll(Arrays.asList(o1,o2,o3));
		
		
	}
	
	
	
	
	

}
