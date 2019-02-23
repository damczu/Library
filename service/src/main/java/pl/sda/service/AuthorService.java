package pl.sda.service;

import pl.sda.domain.model.Author;
import pl.sda.persistance.repository.AuthorRepository;

public class AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Integer addAuthor(String firstName, String lastName){
        Author author = new Author();
        author.setFirstName(firstName);
        author.setLastName(lastName);

        return authorRepository.save(author);
    }


}
