package springintroex.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springintroex.entity.Author;

@Repository
public interface AuthorRespository extends JpaRepository<Author, Long> {
}
