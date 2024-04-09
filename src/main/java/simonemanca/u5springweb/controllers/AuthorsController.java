package simonemanca.u5springweb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import simonemanca.u5springweb.entities.Author;
import simonemanca.u5springweb.services.AuthorsService;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorsController {
    @Autowired
    private AuthorsService authorsService;

    @GetMapping
    public List<Author> getAllAuthors() {
        return authorsService.getAllAuthors();
    }

    @GetMapping("/{id}")
    public Author getAuthorById(@PathVariable int id) {
        return authorsService.getAuthorById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Author createAuthor(@RequestBody Author author) {
        return authorsService.createAuthor(author);
    }

    @PutMapping("/{id}")
    public Author updateAuthor(@PathVariable int id, @RequestBody Author author) {
        return authorsService.updateAuthor(id, author);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAuthor(@PathVariable int id) {
        authorsService.deleteAuthor(id);
    }
}
