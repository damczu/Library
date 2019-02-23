package pl.sda.service;

import org.junit.Assert;
import org.junit.Test;

public class PersonServiceTest {
    @Test
    public void ShouldAddNewPerson(){
        //given
        PersonService personService = new PersonService();
        //when
        Integer result = personService.addPerson("Test","Man","600700800","donotdisturb@gmail.com");
        //then
        Assert.assertNotNull(result);
    }
}
