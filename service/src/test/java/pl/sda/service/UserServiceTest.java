package pl.sda.service;

import org.junit.Assert;
import org.junit.Test;
import pl.sda.domain.model.dto.UserAddDto;
import pl.sda.service.exception.LoginExistsException;
import pl.sda.service.exception.PersonDataNotCreatedException;

public class UserServiceTest {
    @Test
    public void shouldAddUser() throws LoginExistsException, PersonDataNotCreatedException {
        //given
        char[] pwd = {'a','b','c'};
        UserAddDto userAddDto = new UserAddDto();
        userAddDto.login = "adam.miau";
        userAddDto.password = pwd;
        userAddDto.firstName = "Adam";
        userAddDto.lastName = "Miauczyński";
        userAddDto.phone = "500600700";
        userAddDto.email = "adam.miau@gmail.com";

        UserService userService = new UserService();

        //when
        Integer result = userService.addUser(userAddDto);

        //then
        Assert.assertNotNull(result);
    }
}
