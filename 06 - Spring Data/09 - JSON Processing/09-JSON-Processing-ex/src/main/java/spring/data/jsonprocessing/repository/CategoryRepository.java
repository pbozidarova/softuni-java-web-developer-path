package spring.data.jsonprocessing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.data.jsonprocessing.model.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
