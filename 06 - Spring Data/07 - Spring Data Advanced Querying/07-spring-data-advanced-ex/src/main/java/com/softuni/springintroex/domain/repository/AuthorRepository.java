package com.softuni.springintroex.domain.repository;

import com.softuni.springintroex.domain.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface AuthorRepository extends JpaRepository<Author, Long> {

    Set<Author> findAllByFirstNameEndingWith(String end);
}
