package springintroex.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springintroex.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
