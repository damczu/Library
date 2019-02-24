package pl.sda.service;

import org.junit.Assert;
import org.junit.Test;
import pl.sda.persistance.repository.AuthorRepository;

public class AuthorServiceTest {
    @Test
    public void shouldAddNewAuthor(){
        //given
        String firstName = "Stephen";
        String lastName = "King";
        AuthorService authorService = new AuthorService();
        //when
        Integer authorId = authorService.addAuthor(firstName, lastName);
        //then
        Assert.assertNotNull(authorId);

    }
}
