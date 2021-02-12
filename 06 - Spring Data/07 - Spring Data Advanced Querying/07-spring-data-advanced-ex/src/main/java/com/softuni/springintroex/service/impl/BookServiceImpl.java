package com.softuni.springintroex.service.impl;

import com.softuni.springintroex.domain.entities.*;
import com.softuni.springintroex.domain.repository.AuthorRepository;
import com.softuni.springintroex.domain.repository.BookRepository;
import com.softuni.springintroex.domain.repository.CategoryRepository;
import com.softuni.springintroex.service.BookService;
import com.softuni.springintroex.utils.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static com.softuni.springintroex.constants.GlobalConstants.*;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final FileUtil fileUtil;
    private final AuthorRepository authorRepository;
    private final CategoryRepository categoryRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository, FileUtil fileUtil, AuthorRepository authorRepository, CategoryRepository categoryRepository) {
        this.bookRepository = bookRepository;
        this.fileUtil = fileUtil;
        this.authorRepository = authorRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    @Transactional
    public void seedBooksInDB() throws IOException {
        String[] lines = this.fileUtil.readFileContent(BOOKS_FILE_PATH);

        Random random = new Random();

        for (String line : lines) {
            String[] tokens = line.split("\\s+");

            long authorIndex = random.nextInt((int)this.authorRepository.count())+1;
            Author author = this.authorRepository.findById(authorIndex).get();

            EditionType editionType = EditionType.values()[Integer.parseInt(tokens[0])];
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy");
            LocalDate localDate = LocalDate.parse(tokens[1], formatter);
            int copies = Integer.parseInt(tokens[2]);
            BigDecimal price = new BigDecimal(tokens[3]);
            AgeRestriction ageRestriction = AgeRestriction.values()[Integer.parseInt(tokens[4])];
            StringBuilder titleBuilder = new StringBuilder();
            for (int i = 5; i < tokens.length; i++) {
                titleBuilder.append(tokens[i]).append(" ");
            }

            String title = titleBuilder.toString().trim();

            Book book = new Book();
            book.setAuthor(author);
            book.setEditionType(editionType);
            book.setReleaseDate(localDate);
            book.setCopies(copies);
            book.setPrice(price);
            book.setAgeRestriction(ageRestriction);
            book.setTitle(title);

            book.setCategories(this.getRandomCategories());

            this.bookRepository.saveAndFlush(book);

        }
    }

    @Override
    public void printAllBooksByAgeRestriction(String ageRestriction) {
        AgeRestriction ageRestr =AgeRestriction.valueOf(ageRestriction.toUpperCase(Locale.ROOT));
        this.bookRepository.findAllByAgeRestriction(ageRestr)
                    .forEach(b -> System.out.println(b.getTitle()));
    }

    @Override
    public void printAllBooksByEditionTypeAndCopies() {
        this.bookRepository.findAllByEditionTypeAndCopiesLessThan(EditionType.GOLD, 5000)
                .forEach(b -> System.out.println(b.getTitle()));


    }

    @Override
    public void printAllBooksByPriceInBounds() {
        this.bookRepository.findAllByPriceLessThanOrPriceGreaterThan(BigDecimal.valueOf(5), BigDecimal.valueOf(40))
                .forEach(b -> System.out.printf("%s - $%s%n", b.getTitle(), b.getPrice()));
    }

    @Override
    public void printAllBooksByPriceInBoundsJPQL() {
        this.bookRepository.findBooksByPriceOutOfBounds5And40()
                .forEach(b -> System.out.printf("%s - $%s%n", b.getTitle(), b.getPrice()));
    }

    @Override
    public void printAllBooksByBooksNotInYear(String year) {
        this.bookRepository.findAllByReleaseDateIsNotYear(year)
                .forEach(b -> System.out.println(b.getTitle()));
    }

    @Override
    public void printAllBooksBeforeDate(String date) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate localDate = LocalDate.parse(date, dtf);

        this.bookRepository.findAllByReleaseDateIsLessThan(localDate)
                .forEach(b -> System.out.printf("%s %s %s%n", b.getTitle(), b.getEditionType(), b.getPrice() ));


    }

    @Override
    public void printAllBooksWithAuthorsLastNameStartingWith(String start) {
        this.bookRepository.findAllByAuthorLastNameStartingWith(start)
                .forEach(b -> System.out.printf("%s (%s %s)%n", b.getTitle(), b.getAuthor().getFirstName(), b.getAuthor().getLastName()));
    }

    Set<Category> getRandomCategories(){
        Set<Category> categories = new HashSet<>();
        Random random = new Random();

        for (int i = 0; i < 3; i++) {
            long categoryIndex = random.nextInt((int)this.categoryRepository.count()) + 1;
            Category category = this.categoryRepository.findById(categoryIndex).get();

            categories.add(category);
        }


        return categories;
    }
}
