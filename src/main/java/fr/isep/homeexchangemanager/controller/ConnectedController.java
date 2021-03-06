package fr.isep.homeexchangemanager.controller;

import fr.isep.homeexchangemanager.dao.HouseRepository;
import fr.isep.homeexchangemanager.dao.ReservationRepository;
import fr.isep.homeexchangemanager.dao.UserRepository;
import fr.isep.homeexchangemanager.entities.House;
import fr.isep.homeexchangemanager.entities.Reservation;
import fr.isep.homeexchangemanager.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Controller
public class ConnectedController {

    @Autowired
    private UserRepository userDao;
    @Autowired
    private HouseRepository houseDao;

    @Autowired
    private ReservationRepository reservationDao;

    @RequestMapping(value = "/home")
    public String home(
            Model model,
            HttpServletRequest request){

        String userId = (String) request.getSession().getAttribute("userId");

        if(userDao.findById(Long.valueOf(userId)).isEmpty()){return "redirect:/connexion";}

        System.out.println(request.getSession().getAttribute("userId"));
        User user = userDao.findById(Long.valueOf(userId)).orElse(null);
        model.addAttribute("user", user);

        List<House> houses = houseDao.findByOwner(user);
        model.addAttribute("houses", houses);

        List<Reservation> reservations = reservationDao.findByTenant(user);
        model.addAttribute("reservations", reservations);


        return "home";
    }
}
