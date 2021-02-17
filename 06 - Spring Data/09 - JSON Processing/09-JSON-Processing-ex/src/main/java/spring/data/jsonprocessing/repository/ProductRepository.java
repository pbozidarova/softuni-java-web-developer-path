package spring.data.jsonprocessing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.data.jsonprocessing.model.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
