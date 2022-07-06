package udemy.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import udemy.spring.entities.OrderItem;

public interface OrderItemRepositories  extends JpaRepository<OrderItem, Long>{
	
}
