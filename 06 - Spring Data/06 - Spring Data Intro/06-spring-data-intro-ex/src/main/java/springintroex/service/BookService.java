package springintroex.service;

import springintroex.entity.Book;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public interface BookService {

    void seedBooks() throws IOException;
    List<Book> getAllBooksAfterYear2000();
    List<Book> getAllBooksBeforeYear1990();

    List<Book> getAllBooksOfGeorgePowell();
}
