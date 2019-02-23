package pl.sda.service;

import org.junit.Assert;
import org.junit.Test;
import pl.sda.service.exception.LoginExistsException;
import pl.sda.service.exception.PersonDataNotCreatedException;

public class UserServiceTest {
    @Test
    public void shouldAddUser() throws LoginExistsException, PersonDataNotCreatedException {
        //given
        UserService userService = new UserService();
        String login = "test";
        char[] pwd = {'a','b','c'};
        //when
        Integer result = userService.addUser(login,pwd);
        //then
        Assert.assertNotNull(result);
    }
}
