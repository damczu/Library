package pl.sda.service;

import org.junit.Assert;
import org.junit.Test;

public class UserServiceTest {
    @Test
    public void shouldAddUser(){
        //given
        UserService userService = new UserService();
        char[] pwd = {'a','b','c'};
        //when
        Integer result = userService.addUser("test",pwd);
        //then
        Assert.assertNotNull(result);
    }
}
