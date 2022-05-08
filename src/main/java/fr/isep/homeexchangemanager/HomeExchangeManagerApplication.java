package fr.isep.homeexchangemanager;

import fr.isep.homeexchangemanager.dao.UserRepository;
import fr.isep.homeexchangemanager.entities.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class HomeExchangeManagerApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(HomeExchangeManagerApplication.class, args);

        UserRepository userDao = ctx.getBean(UserRepository.class);

        List<User> users = userDao.findAll();
        users.forEach(user -> System.out.println(user.getFirstname()));
    }

}
