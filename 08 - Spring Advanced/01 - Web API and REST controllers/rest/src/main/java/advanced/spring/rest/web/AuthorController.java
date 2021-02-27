package advanced.spring.rest.web;

import advanced.spring.rest.model.Author;
import advanced.spring.rest.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;

@RestController
public class AuthorController implements  AuthorNamespace {

    private AuthorRepository authorRepository;

    @Autowired
    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @GetMapping()
    public List<Author> getAuthors(){
        return authorRepository.findAll();
    }

    @GetMapping("/{authorId}")
    public ResponseEntity<Author> getAuthor(@PathVariable long authorId){

        Optional<Author> theAuthor = authorRepository.findById(authorId);

        return theAuthor
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Author> create(
            UriComponentsBuilder ucBuilder,
            @RequestBody Author author){
        Author newAuthor = authorRepository.save(author);

        return ResponseEntity
                .created(ucBuilder.path("/authors/{authorId}")
                .buildAndExpand(newAuthor.getId()).toUri()).build();
    }

    @DeleteMapping("/{authorId}")
    public ResponseEntity<Author> delete(@PathVariable Long authorId){

        authorRepository.deleteById(authorId);
        return ResponseEntity.noContent().build();
    }
}
