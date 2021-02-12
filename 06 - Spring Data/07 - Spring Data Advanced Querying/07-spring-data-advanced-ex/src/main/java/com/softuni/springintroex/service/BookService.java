package com.softuni.springintroex.service;

import java.io.IOException;

public interface BookService {
    void seedBooksInDB() throws IOException;

    void printAllBooksByAgeRestriction(String ageRestriction);

    void printAllBooksByEditionTypeAndCopies();

    void printAllBooksByPriceInBounds();

    void printAllBooksByPriceInBoundsJPQL();

    void printAllBooksByBooksNotInYear(String year);

    void printAllBooksBeforeDate(String date);

    void printAllBooksWithAuthorsLastNameStartingWith(String start);
}



