package fr.isep.homeexchangemanager;

import fr.isep.homeexchangemanager.dao.HouseRepository;
import fr.isep.homeexchangemanager.dao.UserRepository;
import fr.isep.homeexchangemanager.entities.House;
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
        HouseRepository houseDao = ctx.getBean(HouseRepository.class);

        //seeder :
        if(userDao.findByMail("admin@admin.com") == null) {
            User user = new User("admin", "admin", "admin@admin.com", "admin");
            userDao.save(user);
        }
        if(houseDao.findByTitle("testHouse") == null){
            House house = new House(userDao.findByMail("admin@admin.com"), "testHouse", "description of house");
            houseDao.save(house);
        }
        if(houseDao.findByTitle("testHouse2") == null){
            House house2 = new House(userDao.findByMail("admin@admin.com"), "testHouse2", "description of house number 2");
            houseDao.save(house2);
        }

    }

}
