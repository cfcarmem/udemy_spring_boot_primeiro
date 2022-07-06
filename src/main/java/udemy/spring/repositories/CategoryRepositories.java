package udemy.spring.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import udemy.spring.entities.Category;


@Repository
public interface CategoryRepositories extends JpaRepository<Category, Long>{
}
