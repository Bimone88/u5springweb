package simonemanca.u5springweb.services;

import org.springframework.stereotype.Service;
import simonemanca.u5springweb.entities.Author;
import simonemanca.u5springweb.exceptions.NotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class AuthorsService {
    private final List<Author> authors = new ArrayList<>();
    private final Random rnd = new Random();

    public List<Author> getAllAuthors() {
        return authors;
    }

    public Author getAuthorById(int id) {
        return authors.stream()
                .filter(author -> author.getId() == id)
                .findFirst()
                .orElseThrow(() -> new NotFoundException(id));
    }

    public Author createAuthor(Author author) {
        author.setId(rnd.nextInt(1, 10000)); // Assicura un ID unico
        authors.add(author);
        return author;
    }

    public Author updateAuthor(int id, Author updatedAuthor) {
        Author author = getAuthorById(id);
        author.setName(updatedAuthor.getName());
        author.setSurname(updatedAuthor.getSurname());
        author.setEmail(updatedAuthor.getEmail());
        author.setDateOfBirth(updatedAuthor.getDateOfBirth());
        author.setAvatar(updatedAuthor.getAvatar());
        return author;
    }

    public void deleteAuthor(int id) {
        authors.removeIf(author -> author.getId() == id);
    }
}

