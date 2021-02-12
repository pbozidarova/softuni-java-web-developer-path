package com.softuni.springintroex.service.impl;

import com.softuni.springintroex.constants.GlobalConstants;
import com.softuni.springintroex.domain.entities.Author;
import com.softuni.springintroex.domain.repository.AuthorRepository;
import com.softuni.springintroex.service.AuthorService;
import com.softuni.springintroex.utils.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

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
}
