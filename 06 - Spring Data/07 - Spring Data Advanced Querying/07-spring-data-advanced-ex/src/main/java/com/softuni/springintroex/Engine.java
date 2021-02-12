package com.softuni.springintroex;

import com.softuni.springintroex.service.AuthorService;
import com.softuni.springintroex.service.BookService;
import com.softuni.springintroex.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Component
public class Engine implements CommandLineRunner {
    private final CategoryService categoryService;
    private final AuthorService authorService;
    private final BookService bookService;
    private final BufferedReader reader;
    @Autowired
    public Engine(CategoryService categoryService, AuthorService authorService, BookService bookService) {
        this.categoryService = categoryService;
        this.authorService = authorService;
        this.bookService = bookService;
        this.reader  = new BufferedReader (new InputStreamReader(System.in));;
    }

    @Override
    public void run(String... args) throws Exception {
        //seedData();
        System.out.println("Please select a task from 1 to 11 to review:");
        String task = reader.readLine();

        switch (task){
            case "1":
                //1.	Books Titles by Age Restriction
                //Write a program that prints the titles of all books, for which the age restriction matches the given input
                //(minor, teen or adult). Ignore casing of the input.
                bookTitlesByAgeRestriction(reader.readLine());
                break;
            case "2":
                //2.	Golden Books
                //Write a program that prints the titles of the golden edition books, which have less than 5000 copies.
                goldenBooksWithCopies();
                break;
            case "3":
                //3.	Books by Price
                //Write a program that prints the titles and prices of books with price lower than 5 and higher than 40.
                bookByPrice();

                System.out.println("-".repeat(80));

                bookByPriceJPQL();
                break;
            case "4":
                //4.	Not Released Books
                //Write a program that prints the titles of all books that are NOT released in a given year.
                notReleasedBooks();
                break;
            case "5":
                //5.	Books Released Before Date
                //Write a program that prints the title, the edition type and the price of books, which are released before a given date. The date will be in the format dd-MM-yyyy.
                booksReleasedBeforeDate();
                break;
            case "6":
                //6.	Authors Search
                //Write a program that prints the names of those authors, whose first name ends with a given string.
                authorsSearch();
                break;
            case "7":
                //7.	Books Search
                //Write a program that prints the titles of books, which contain a given string (regardless of the casing).

                break;
            case "8":
                //8.	Book Titles Search
                //Write a program that prints the titles of books, which are written by authors, whose last name starts with a given string.
                bookTitlesSearch();
                break;
            case "9":
                //9.	Count Books
                //Write a program that prints the number of books, whose title is longer than a given number.

                break;
            case "10":
                //10.	Total Book Copies
                //Write a program that prints the total number of book copies by author. Order the results descending by total book copies.

                break;
            case "11":
                //11.	Reduced Book
                //Write a program that prints information (title, edition type, age restriction and price) for a book by given title. When retrieving the book information select only those fields and do NOT include any other information in the returned result.

                break;
            default:
                break;
        }
    }

    private void bookTitlesSearch() throws IOException {
        System.out.println("Please specify author's last name starting string");
        String start = reader.readLine();

        this.bookService.printAllBooksWithAuthorsLastNameStartingWith(start);

    }

    private void authorsSearch() throws IOException {
        System.out.println("Please specify starting string for the author's name");
        String end = reader.readLine();

        this.authorService.printAllAuthorsWithEndingString(end);
    }

    private void booksReleasedBeforeDate() throws IOException {
        System.out.println("Specify release date:");
        String date = reader.readLine();
        this.bookService.printAllBooksBeforeDate(date);
    }

    private void notReleasedBooks() throws IOException {
        System.out.println("Specify release year:");
        String year = reader.readLine();
        this.bookService.printAllBooksByBooksNotInYear(year);
    }

    private void bookByPriceJPQL() {
        this.bookService.printAllBooksByPriceInBoundsJPQL();
    }

    private void bookByPrice() {
        this.bookService.printAllBooksByPriceInBounds();
    }

    private void goldenBooksWithCopies() {
        this.bookService.printAllBooksByEditionTypeAndCopies();
    }

    private void bookTitlesByAgeRestriction(String restriction) {
        this.bookService.printAllBooksByAgeRestriction(restriction);
    }

    void seedData() throws IOException {
        this.categoryService.seedCategoriesInDb();
        this.authorService.seedAuthorsInDB();
        this.bookService.seedBooksInDB();
    }
}
