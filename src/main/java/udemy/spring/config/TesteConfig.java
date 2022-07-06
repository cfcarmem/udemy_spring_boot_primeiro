package udemy.spring.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import udemy.spring.entities.Category;
import udemy.spring.entities.Order;
import udemy.spring.entities.Product;
import udemy.spring.entities.Usuario;
import udemy.spring.entities.enums.OrderStatus;
import udemy.spring.repositories.CategoryRepositories;
import udemy.spring.repositories.OrderRepositories;
import udemy.spring.repositories.ProductRepositories;
import udemy.spring.repositories.UserRepositories;

@Configuration
@Profile("test") //o nome test é o mesmo do properties test
//esse teste vamos popular o banco de dados
public class TesteConfig  implements CommandLineRunner{
	@Autowired   //dando uma injeção de dependência. Associa uma instância de UserRepositeires aqui
	private UserRepositories userRepo;
	
	@Autowired
	private OrderRepositories orderRepo;
	
	@Autowired
	private CategoryRepositories categoryRepo;
	
	@Autowired
	private ProductRepositories productRepo;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Category cat1 = new Category(null, "Electronics"); 
		Category cat2 = new Category(null, "Books"); 
		Category cat3 = new Category(null, "Computers"); 
		categoryRepo.saveAll(Arrays.asList(cat1,cat2,cat3));
		
		
		Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, ""); 
		Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, ""); 
		Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, ""); 
		Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, ""); 
		Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, ""); 
		productRepo.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
		
		
		Usuario u1 = new Usuario(null, "Carlos", "carlos@gmail.com", "988888888", "123456"); 
		Usuario u2 = new Usuario(null, "Paulo", "paulo@gmail.com", "977777777", "123456"); 
		userRepo.saveAll(Arrays.asList(u1,u2));
		
		//usando padrão UTC
		Order o1 = new Order(null, Instant.parse("2022-06-20T19:53:07Z"),OrderStatus.PAYMENT, u1); 
		Order o2 = new Order(null, Instant.parse("2022-07-21T03:42:10Z"),OrderStatus.PAYMENT, u2); 
		Order o3 = new Order(null, Instant.parse("2022-07-22T15:21:22Z"),OrderStatus.CANCELED, u1);
		orderRepo.saveAll(Arrays.asList(o1,o2,o3));
		
		
	}
	
	
	
	
	

}
