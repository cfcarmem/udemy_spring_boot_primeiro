package udemy.spring.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import udemy.spring.entities.Product;


@Repository
public interface ProductRepositories extends JpaRepository<Product, Long>{
}
