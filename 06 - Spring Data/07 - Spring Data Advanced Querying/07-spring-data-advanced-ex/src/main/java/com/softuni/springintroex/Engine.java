package com.softuni.springintroex;

import com.softuni.springintroex.service.AuthorService;
import com.softuni.springintroex.service.BookService;
import com.softuni.springintroex.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class Engine implements CommandLineRunner {
    private final CategoryService categoryService;
    private final AuthorService authorService;
    private final BookService bookService;

    @Autowired
    public Engine(CategoryService categoryService, AuthorService authorService, BookService bookService) {
        this.categoryService = categoryService;
        this.authorService = authorService;
        this.bookService = bookService;
    }

    @Override
    public void run(String... args) throws Exception {
        //seedData();

    }

    void seedData() throws IOException {
        this.categoryService.seedCategoriesInDb();
        this.authorService.seedAuthorsInDB();
        this.bookService.seedBooksInDB();
    }
}
