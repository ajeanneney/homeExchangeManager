package fr.isep.homeexchangemanager.controller;

import fr.isep.homeexchangemanager.dao.UserRepository;
import fr.isep.homeexchangemanager.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

@Controller
public class ConnexionController {

    @Autowired
    private UserRepository userDao;

    @RequestMapping(value = "/connexion")
    public String connexion(
            @RequestParam(name = "mail", defaultValue = "") String mail,
            @RequestParam(name = "password", defaultValue = "") String password,
            HttpServletResponse response){

        if(!Objects.equals(mail, "") && !Objects.equals(password, "")) {
            User user = userDao.findByMail(mail);
            if(Objects.equals(user.getPassword(), password)){
                Cookie cookie = new Cookie("userId", user.getId().toString());
                response.addCookie(cookie);
                return "redirect:home";
            } else{
                System.out.println("mauvais password");
            }
        }
        return "connexion";
    }

    @RequestMapping(value = "/connected")
    public String connected(){
        return "connected";
    }

}
