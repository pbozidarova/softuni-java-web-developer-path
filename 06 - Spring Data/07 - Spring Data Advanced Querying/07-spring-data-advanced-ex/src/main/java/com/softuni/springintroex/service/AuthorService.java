package com.softuni.springintroex.service;

import com.softuni.springintroex.domain.entities.Book;
import com.softuni.springintroex.service.models.BookInfo;
import org.springframework.stereotype.Repository;

import java.io.IOException;

@Repository
public interface AuthorService {
    void seedAuthorsInDB() throws IOException;

    void printAllAuthorsWithEndingString(String start);

    void printAllAuthorsByBookCopies();

//    void printAllAuthorsByBookCopiesJPQL();

}
