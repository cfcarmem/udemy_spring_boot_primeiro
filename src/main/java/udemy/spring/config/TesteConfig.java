package udemy.spring.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import udemy.spring.entities.Category;
import udemy.spring.entities.Order;
import udemy.spring.entities.OrderItem;
import udemy.spring.entities.Payment;
import udemy.spring.entities.Product;
import udemy.spring.entities.Usuario;
import udemy.spring.entities.enums.OrderStatus;
import udemy.spring.repositories.CategoryRepositories;
import udemy.spring.repositories.OrderItemRepositories;
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
	
	@Autowired
	private OrderItemRepositories orderItemRepo;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Category cat1 = new Category(null, "Electronics"); 
		Category cat2 = new Category(null, "Books"); 
		Category cat3 = new Category(null, "Computers"); 
		
		
		
		Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, ""); 
		Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, ""); 
		Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, ""); 
		Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, ""); 
		Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, ""); 
		
		categoryRepo.saveAll(Arrays.asList(cat1,cat2,cat3));
		productRepo.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
		
		//vamos incluir a categoria no produto. vai gravar na tabela product_category. Não precisa criar classe para tabela product_category
		p1.getCategories().add(cat2);
		p2.getCategories().add(cat1);
		p2.getCategories().add(cat3);
		
		p3.getCategories().add(cat3);
		p4.getCategories().add(cat3);
		p5.getCategories().add(cat2);
		productRepo.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
		
		
		Usuario u1 = new Usuario(null, "Carlos", "carlos@gmail.com", "988888888", "123456"); 
		Usuario u2 = new Usuario(null, "Paulo", "paulo@gmail.com", "977777777", "123456"); 
		userRepo.saveAll(Arrays.asList(u1,u2));
		
		//usando padrão UTC
		Order o1 = new Order(null, Instant.parse("2022-06-20T19:53:07Z"),OrderStatus.PAYMENT, u1); 
		Order o2 = new Order(null, Instant.parse("2022-07-21T03:42:10Z"),OrderStatus.PAYMENT, u2); 
		Order o3 = new Order(null, Instant.parse("2022-07-22T15:21:22Z"),OrderStatus.CANCELED, u1);
		orderRepo.saveAll(Arrays.asList(o1,o2,o3));
		
		
		OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice()); 
		OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice()); 
		OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice()); 
		OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPrice()); 
        orderItemRepo.saveAll(Arrays.asList(oi1,oi2,oi3,oi4));
		
		Payment py1 = new Payment(null,Instant.parse("2022-06-20T21:53:07Z"),o1);
		//não chama o repository do próprio Pa\yment. Uso do Order. Somente quando for OneToOne
		o1.setPayment(py1);
		orderRepo.save(o1);
        
	}
	
	
	
	
	

}
