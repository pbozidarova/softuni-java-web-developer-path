package springintroex.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import springintroex.entity.Author;
import springintroex.entity.Book;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findAllByReleaseDateAfter(LocalDate localDate);
    List<Book> findAllByReleaseDateBefore(LocalDate localDate);

    @Query("SELECT b FROM Book b  WHERE b.author.firstName = :firstName AND b.author.lastName = :lastName " +
            "ORDER BY b.releaseDate DESC, b.title ASC")
    List<Book> findAllByAuthorOrdered(String firstName, String lastName);

}
