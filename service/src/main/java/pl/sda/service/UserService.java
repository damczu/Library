package pl.sda.service;

import org.hibernate.Session;
import pl.sda.domain.model.User;
import pl.sda.persistance.hibernate.HibernateUtil;
import pl.sda.persistance.repository.UserRepository;

import java.time.LocalDateTime;

public class UserService {

    public Integer addUser(String login, char[] password){
        User user = new User();
        user.setLogin(login);
        user.setPassword(password);
        user.setCreateDate(LocalDateTime.now());

        Session session = HibernateUtil
                .getSessionFactory()
                .openSession();
        UserRepository userRepository = new UserRepository(session);

        Integer result =  userRepository.save(user);

        session.close();
        HibernateUtil.shutdown();

        return result;
    }
}
