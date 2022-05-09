package fr.isep.homeexchangemanager.controller;

import fr.isep.homeexchangemanager.dao.UserRepository;
import fr.isep.homeexchangemanager.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Objects;

@Controller
public class ConnexionController {

    @Autowired
    private UserRepository userDao;

    @RequestMapping(value = "/connexion")
    public String search(
            @RequestParam(name = "mail", defaultValue = "") String mail,
            @RequestParam(name = "password", defaultValue = "") String password){
        System.out.println(mail);
        System.out.println(password);

        if(!Objects.equals(mail, "")) {
            User user = userDao.findByMail(mail);
            if(Objects.equals(user.getPassword(), password)){
                System.out.println("connecté");
            } else{
                System.out.println("mauvais password");
            }
        }
        return "connexion";
    }

}
