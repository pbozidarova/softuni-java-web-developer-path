package springintroex.service.impl;

import org.springframework.stereotype.Service;
import springintroex.entity.Author;
import springintroex.repository.AuthorRepository;
import springintroex.service.AuthorService;
import springintroex.util.FileUtil;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static springintroex.constants.GlobalConstants.*;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRespository;
    private final FileUtil fileUtil;

    public AuthorServiceImpl(AuthorRepository authorRespository, FileUtil fileUtil) {
        this.authorRespository = authorRespository;
        this.fileUtil = fileUtil;
    }

    @Override
    public void seedAuthors() throws IOException {
        String[] fileContent = this.fileUtil
                .readFileContent(AUTHOR_FILE_PATH);

        if(this.authorRespository.count() != 0){
            return;
        }

        Arrays.stream(fileContent)
                .forEach(r -> {
                    String[] params = r.split("\\s+");
                    Author author = new Author(params[0], params[1]);

                    this.authorRespository.saveAndFlush(author);
                });


    }

    @Override
    public long getAllAuthorsCount() {
        return this.authorRespository.count();
    }

    @Override
    public Author findAuthorById(long id) {
        return this.authorRespository.getOne(id);
    }


    @Override
    public List<Author> getAllAuthorsByCountOfBooks() {

        return this.authorRespository.findAuthorsByCountOfBooks();
    }
}
