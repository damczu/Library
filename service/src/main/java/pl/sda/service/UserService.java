package pl.sda.service;

import org.hibernate.Session;
import pl.sda.domain.model.User;
import pl.sda.persistance.hibernate.HibernateUtil;
import pl.sda.persistance.repository.UserRepository;

public class UserService {

    public void addUser(String login, char[] password){
        User user = new User();
        user.setLogin(login);
        user.setPassword(password);

        Session session = HibernateUtil
                .getSessionFactory()
                .openSession();
        UserRepository userRepository = new UserRepository(session);
        userRepository.save(user);
    }
}
