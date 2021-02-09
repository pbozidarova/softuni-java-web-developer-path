package springintroex.service;

import springintroex.entity.Author;

import java.io.IOException;
import java.util.List;

public interface AuthorService {
    void seedAuthors() throws IOException;

    long getAllAuthorsCount();

    Author findAuthorById(long id);

    List<Author> getAllAuthorsByCountOfBooks();
}
