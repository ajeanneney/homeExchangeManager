package fr.isep.homeexchangemanager.controller;

import fr.isep.homeexchangemanager.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ConnexionController {

    @Autowired
    private UserRepository userDao;

    @RequestMapping(value = "/connexion")
    public String search(
            @RequestParam(name = "username", defaultValue = "") String username,
            @RequestParam(name = "password", defaultValue = "") String password){
        System.out.println(username);
        System.out.println(password);
        return "connexion";
    }

}
