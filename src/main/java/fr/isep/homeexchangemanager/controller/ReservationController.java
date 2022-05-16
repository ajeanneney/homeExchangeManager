package fr.isep.homeexchangemanager.controller;

import fr.isep.homeexchangemanager.dao.HouseRepository;
import fr.isep.homeexchangemanager.dao.UserRepository;
import fr.isep.homeexchangemanager.entities.House;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Objects;

@Controller
public class ReservationController {

    @Autowired
    UserRepository userDao;

    @Autowired
    HouseRepository houseDao;

    @RequestMapping(value = "/search")
    public String search(
            Model model,
            @CookieValue(value = "userId", defaultValue = "") String userId){

        if(Objects.equals(userId, "") || userDao.findById(Long.valueOf(userId)).isEmpty()){return "redirect:connexion";} //si pas connecté retour page connexion

        List<House> houses = houseDao.findAll();
        model.addAttribute("houses", houses);
        return "searchhouse";
    }
}
