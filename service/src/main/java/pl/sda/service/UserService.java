package pl.sda.service;

import pl.sda.domain.model.User;
import pl.sda.domain.model.dto.UserAddDto;
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

    public Integer addUser(UserAddDto userAddDto) throws LoginExistsException, PersonDataNotCreatedException {

        if(userRepository.loginExists(userAddDto.login)){
            throw new LoginExistsException(userAddDto.login);
        }

        Integer personId = personService.addPerson(userAddDto);
        if(personId == null){
            throw new PersonDataNotCreatedException();
        }

        User user = new User();
        user.setLogin(userAddDto.login);
        user.setPassword(userAddDto.password);
        user.setPersonId(personId);
        user.setCreateDate(LocalDateTime.now());

        return userRepository.save(user);
}
}
