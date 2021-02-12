package com.softuni.springintroex.service;

import org.springframework.stereotype.Repository;

import java.io.IOException;

@Repository
public interface AuthorService {
    void seedAuthorsInDB() throws IOException;
}
