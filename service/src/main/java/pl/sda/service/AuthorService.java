package pl.sda.service;

import pl.sda.domain.model.Author;
import pl.sda.persistance.repository.AuthorRepository;

import java.util.List;

public class AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorService() {
        this.authorRepository = new AuthorRepository();
    }

    public Integer addAuthor(String firstName, String lastName){
        Author author = new Author();
        author.setFirstName(firstName);
        author.setLastName(lastName);

        return authorRepository.save(author);
    }


    public List<Author> findAuthors(List<Integer> authors) {
        return authorRepository.findAuthorsByIdList(authors);
    }

    public Integer addAuthor(String author) {
        return null;
    }
}
