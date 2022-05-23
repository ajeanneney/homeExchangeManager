package fr.isep.homeexchangemanager;

import fr.isep.homeexchangemanager.dao.HouseRepository;
import fr.isep.homeexchangemanager.dao.PhotoRepository;
import fr.isep.homeexchangemanager.dao.ReservationRepository;
import fr.isep.homeexchangemanager.dao.UserRepository;
import fr.isep.homeexchangemanager.entities.House;
import fr.isep.homeexchangemanager.entities.Reservation;
import fr.isep.homeexchangemanager.entities.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class HomeExchangeManagerApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(HomeExchangeManagerApplication.class, args);
        UserRepository userDao = ctx.getBean(UserRepository.class);
        HouseRepository houseDao = ctx.getBean(HouseRepository.class);
        ReservationRepository reservationDao = ctx.getBean(ReservationRepository.class);
        PhotoRepository photoDao = ctx.getBean(PhotoRepository.class);

        //cleaner :
        reservationDao.deleteAll();
        photoDao.deleteAll();
        houseDao.deleteAll();
        userDao.deleteAll();



        //seeder :
        User user = new User("admin", "admin", "admin@admin.com", "admin");
        House house = new House(user, "testHouse", "description of house");
        House house2 = new House(user, "testHouse2", "description of house number 2");
        User user2 = new User("user", "user", "user@user.com", "user");
        House houseUser = new House(user2, "testHouseUser", "description of house User");
        House houseUser2 = new House(user2, "testHouseUser2", "description of house User number 2");
        Reservation reservation = new Reservation(houseUser2, user, new Date(), new Date(), false);
        Reservation reservation1 = new Reservation(houseUser, user, new Date(), new Date(), true);

        userDao.save(user);
        houseDao.save(house);
        houseDao.save(house2);
        userDao.save(user2);
        houseDao.save(houseUser);
        houseDao.save(houseUser2);
        reservationDao.save(reservation);
        reservationDao.save(reservation1);

    }

}
