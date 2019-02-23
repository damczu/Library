package pl.sda.service;

import org.hibernate.Session;
import pl.sda.domain.model.User;
import pl.sda.persistance.hibernate.HibernateUtil;
import pl.sda.persistance.repository.UserRepository;
import pl.sda.service.exception.LoginExistsException;

import java.time.LocalDateTime;

public class UserService {
    private final UserRepository userRepository;

    public UserService() {
        this.userRepository = new UserRepository();
    }

    public Integer addUser(String login, char[] password) throws LoginExistsException {

        if(userRepository.loginExists(login)){
            throw new LoginExistsException(login);
        }
        User user = new User();
        user.setLogin(login);
        user.setPassword(password);
        user.setCreateDate(LocalDateTime.now());

        Integer result =  userRepository.save(user);

        return result;
    }
}
