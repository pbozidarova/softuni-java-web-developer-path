package com.softuni.springintroex.service.impl;

import com.softuni.springintroex.domain.entities.Author;
import com.softuni.springintroex.domain.entities.Book;
import com.softuni.springintroex.domain.repository.AuthorRepository;
import com.softuni.springintroex.service.AuthorService;
import com.softuni.springintroex.utils.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;

import static com.softuni.springintroex.constants.GlobalConstants.*;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final FileUtil fileUtil;
    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorServiceImpl(FileUtil fileUtil, AuthorRepository authorRepository) {
        this.fileUtil = fileUtil;
        this.authorRepository = authorRepository;
    }

    @Override
    public void seedAuthorsInDB() throws IOException {
        String[] lines = this.fileUtil.readFileContent(AUTHORS_FILE_PATH);
        for (String line : lines) {
            String[] tokens = line.split("\\s+");

            Author author = new Author(tokens[0], tokens[1]);

            this.authorRepository.saveAndFlush(author);
        }
    }

    @Override
    public void printAllAuthorsWithEndingString(String end) {
        this.authorRepository.findAllByFirstNameEndingWith(end)
                .forEach(a -> System.out.printf("%s %s%n", a.getFirstName(), a.getLastName()));
    }

    @Override
    public void printAllAuthorsByBookCopies() {
        List<Author> authors = this.authorRepository.findAll();

        Map<String, Integer> authorCopies = new HashMap<>();

        authors.forEach(author -> {
           int copies =  author
                            .getBooks()
                            .stream()
                            .mapToInt(Book::getCopies).sum();
           authorCopies.put(author.getFirstName() + " " + author.getLastName(), copies);
        });

        authorCopies
                .entrySet()
                .stream()
                .sorted((current, next ) -> Integer.compare(next.getValue(), current.getValue()))
                .forEach(author -> System.out.printf("%s %d%n", author.getKey(), author.getValue()));

    }
//
//    @Override
//    public void printAllAuthorsByBookCopiesJPQL() {
//        this.authorRepository.findAuthorsByCountOfBooks()
//                .forEach(a -> System.out.printf("%s %s %d%n", a.getFirst_name(), a.getLast_name(), a.getCopies()));
//    }
}
