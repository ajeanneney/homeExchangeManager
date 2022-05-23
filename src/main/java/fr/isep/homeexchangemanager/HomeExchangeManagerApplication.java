package fr.isep.homeexchangemanager;

import fr.isep.homeexchangemanager.dao.*;
import fr.isep.homeexchangemanager.entities.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Date;

@SpringBootApplication
public class HomeExchangeManagerApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(HomeExchangeManagerApplication.class, args);
        UserRepository userDao = ctx.getBean(UserRepository.class);
        HouseRepository houseDao = ctx.getBean(HouseRepository.class);
        ReservationRepository reservationDao = ctx.getBean(ReservationRepository.class);
        PhotoRepository photoDao = ctx.getBean(PhotoRepository.class);
        ServiceRepository serviceDao = ctx.getBean(ServiceRepository.class);
        ConstraintRepository constraintDao = ctx.getBean(ConstraintRepository.class);

//        //cleaner :
//        reservationDao.deleteAll();
//        photoDao.deleteAll();
//        houseDao.deleteAll();
//        userDao.deleteAll();

        //create constraints
//        constraintDao.save(new Constraint("Non fumeur", "Cette maison est une maison non fumeur"));
//        constraintDao.save(new Constraint("Pas d'enfants", "Cette location n'accepte pas les enfants"));
//        constraintDao.save(new Constraint("2 enfants maximum", "Cette location n'accepte que 2 enfants maximum"));
//        constraintDao.save(new Constraint("Pas d'animaux", "Les animaux ne sont pas acceptés dans cette maison"));

        //create services
        serviceDao.save(new Service("Nettoyage", "Vous devrez nettoyer la maison à la fin de votre séjour"));
        serviceDao.save(new Service("Nettoyage", "Vous devrez nettoyer la maison à la fin de votre séjour"));


//        //seeder :
//        User user = new User("admin", "admin", "admin@admin.com", "admin");
//        House house = new House(user, "testHouse", "description of house");
//        House house2 = new House(user, "testHouse2", "description of house number 2");
//        User user2 = new User("user", "user", "user@user.com", "user");
//        House houseUser = new House(user2, "testHouseUser", "description of house User");
//        House houseUser2 = new House(user2, "testHouseUser2", "description of house User number 2");
//        Reservation reservation = new Reservation(houseUser2, user, new Date(), new Date(), false);
//        Reservation reservation1 = new Reservation(houseUser, user, new Date(), new Date(), true);
//
//        userDao.save(user);
//        houseDao.save(house);
//        houseDao.save(house2);
//        userDao.save(user2);
//        houseDao.save(houseUser);
//        houseDao.save(houseUser2);
//        reservationDao.save(reservation);
//        reservationDao.save(reservation1);

    }

}
