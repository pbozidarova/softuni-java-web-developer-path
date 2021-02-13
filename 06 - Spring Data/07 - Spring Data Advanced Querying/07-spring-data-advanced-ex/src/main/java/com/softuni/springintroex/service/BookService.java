package com.softuni.springintroex.service;

import com.softuni.springintroex.domain.entities.Book;
import com.softuni.springintroex.service.models.BookInfo;

import java.io.IOException;

public interface BookService {
    void seedBooksInDB() throws IOException;

    void printAllBooksByAgeRestriction(String ageRestriction);

    void printAllBooksByEditionTypeAndCopies();

    void printAllBooksByPriceInBounds();

    void printAllBooksByPriceInBoundsJPQL();

    void printAllBooksByBooksNotInYear(String year);

    void printAllBooksBeforeDate(String date);

    void printAllBooksWithTitlesContaining(String str);

    void printAllBooksWithAuthorsLastNameStartingWith(String start);

    void printCountOfBooksWithTitleLengthBiggerThen(int length);

    BookInfo findBookByTitle(String title);

    void printUpdatedCopies(String date, int copies);
}



