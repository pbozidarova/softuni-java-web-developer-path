package com.softuni.springintroex.domain.repository;

import com.softuni.springintroex.domain.entities.Author;
import com.softuni.springintroex.domain.entities.Book;
import com.softuni.springintroex.domain.entities.CopiesAuthorsRes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;

public interface AuthorRepository extends JpaRepository<Author, Long> {

    Set<Author> findAllByFirstNameEndingWith(String end);
//
//    @Query("SELECT a.firstName, a.lastName, sum(b.copies) FROM Author a, Book b")
//   Set<CopiesAuthorsRes> findAuthorsByCountOfBooks();


}
