package com.softuni.springintroex.domain.repository;

import com.softuni.springintroex.domain.entities.AgeRestriction;
import com.softuni.springintroex.domain.entities.Book;
import com.softuni.springintroex.domain.entities.EditionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    Set<Book> findAllByAgeRestriction(AgeRestriction ageRestriction);

    Set<Book> findAllByEditionTypeAndCopiesLessThan(EditionType editionType, int copies);

    Set<Book> findAllByPriceLessThanOrPriceGreaterThan(BigDecimal lowerBound, BigDecimal upperBound);

    @Query("SELECT b FROM Book b WHERE b.price NOT BETWEEN 5 AND 40")
    Set<Book> findBooksByPriceOutOfBounds5And40();

    @Query("SELECT b FROM Book b WHERE SUBSTRING(b.releaseDate, 0, 4) NOT LIKE :year")
    Set<Book> findAllByReleaseDateIsNotYear(String year);

    Set<Book> findAllByReleaseDateIsLessThan(LocalDate date);

    //
    Set<Book> findAllByAuthorLastNameStartingWith(String start);
}
