package pl.sda.service;

import pl.sda.domain.model.User;
import pl.sda.persistance.repository.UserRepository;
import pl.sda.service.exception.LoginExistsException;
import pl.sda.service.exception.PersonDataNotCreatedException;

import java.time.LocalDateTime;

public class UserService {
    private final UserRepository userRepository;
    private final PersonService personService;

    public UserService() {
        this.userRepository = new UserRepository();
        this.personService = new PersonService();
    }

    public Integer addUser(String login, char[] password) throws LoginExistsException, PersonDataNotCreatedException {

        if(userRepository.loginExists(login)){
            throw new LoginExistsException(login);
        }

        Integer personId = personService.addPerson("ada", "asa", "222", "aaa@kk.pl");
        if(personId == null){
            throw new PersonDataNotCreatedException();
        }
        User user = new User();
        user.setLogin(login);
        user.setPassword(password);
        user.setPersonId(personId);
        user.setCreateDate(LocalDateTime.now());

        return userRepository.save(user);
}
}
