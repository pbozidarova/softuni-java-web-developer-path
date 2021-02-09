package springintroex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;
import springintroex.entity.Author;
import springintroex.entity.Book;
import springintroex.service.AuthorService;
import springintroex.service.BookService;
import springintroex.service.CategoryService;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class AppController implements CommandLineRunner {

    private final CategoryService categoryService;
    private final AuthorService authorService;
    private final BookService bookService;
    private final BufferedReader reader;

    @Autowired
    public AppController(CategoryService categoryService, AuthorService authorService, BookService bookService) {
        this.categoryService = categoryService;
        this.authorService = authorService;
        this.bookService = bookService;
        this.reader = new BufferedReader (new InputStreamReader(System.in));
    }

    @Override
    public void run(String... args) throws Exception {
        this.categoryService.seedCategories();
        this.authorService.seedAuthors();
        this.bookService.seedBooks();

        System.out.println("Please choose a task (from 1 to ...) that you would like to review: ");
        String task = reader.readLine();
//
//        Write Queries
//        Write the following queries that:
        switch (task){
            case "1":
//              1.	Get all books after the year 2000. Print only their titles.
                List<Book> books = this.bookService.getAllBooksAfterYear2000();
                break;
            case "2":
//              2.	Get all authors with at least one book with release date before 1990. Print their first name and last name.
                Set<String> authors = new HashSet<>();
                this.bookService.getAllBooksBeforeYear1990()
                        .forEach(b -> {
                            authors.add(String.format("%s %s", b.getAuthor().getFirstName(), b.getAuthor().getLastName()));
                        });
                authors.stream()
                       .distinct()
                       .forEach(System.out::println);
                break;
            case "3":
//              3.	Get all authors, ordered by the number of their books (descending). Print their first name, last name and book count.
                this.authorService.getAllAuthorsByCountOfBooks()
                        .forEach(a -> {
                            System.out.printf("%s %s %d%n",
                                    a.getFirstName(), a.getLastName(), a.getBooks().size());
                        });

                break;
            case "4":
//              4.	Get all books from author George Powell, ordered by their release date (descending), then by book title (ascending). Print the book's title, release date and copies.
                this.bookService.getAllBooksOfGeorgePowell().forEach(b -> System.out.println(b.getTitle()));
                break;
            default:
                break;
        }
    }



}