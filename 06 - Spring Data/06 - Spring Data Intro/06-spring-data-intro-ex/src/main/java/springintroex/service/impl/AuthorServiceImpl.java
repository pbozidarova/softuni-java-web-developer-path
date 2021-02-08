package springintroex.service.impl;

import org.springframework.stereotype.Service;
import springintroex.constants.GlobalConstants;
import springintroex.entity.Author;
import springintroex.repository.AuthorRespository;
import springintroex.service.AuthorService;
import springintroex.util.FileUtil;

import java.io.IOException;
import java.util.Arrays;

import static springintroex.constants.GlobalConstants.*;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRespository authorRespository;
    private final FileUtil fileUtil;

    public AuthorServiceImpl(AuthorRespository authorRespository, FileUtil fileUtil) {
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
}
