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
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

@Controller
public class ReservationController {

    @Autowired
    UserRepository userDao;

    @Autowired
    HouseRepository houseDao;

    @Autowired
    ReservationRepository reservationDao;

    @RequestMapping(value = "/search")
    public String search(
            Model model,
            @CookieValue(value = "userId", defaultValue = "") String userId){

        if(Objects.equals(userId, "") || userDao.findById(Long.valueOf(userId)).isEmpty()){return "redirect:/";} //si pas connecté retour page connexion

        List<House> houses = houseDao.findAll();
        model.addAttribute("houses", houses);
        return "searchhouse";
    }

    @RequestMapping("/reserve/{id}")
    public String reserveHouse(
            @CookieValue(value = "userId", defaultValue = "") String userId,
            @PathVariable(value = "id") String houseId,
            @RequestParam(name = "debut", required = false) String debut,
            @RequestParam(name = "fin", required = false) String fin,
            Model model
    ) throws ParseException {
        if (Objects.equals(userId, "") || userDao.findById(Long.valueOf(userId)).isEmpty()) {return "redirect:/";} //si pas connecté retour page connexion

        User tenant = userDao.findById(Long.valueOf(userId)).orElse(null);
        House house = houseDao.findById(Long.valueOf(houseId)).orElse(null);
        model.addAttribute("house", house);

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);

        if(debut != null && fin != null){
            Reservation reservation = new Reservation(house, tenant, formatter.parse(debut), formatter.parse(fin), false);
            reservationDao.save(reservation);
            return "redirect:/home";
        }

        return "reservehouse";
    }
}
