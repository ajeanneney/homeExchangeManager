package fr.isep.homeexchangemanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

@Controller
public class MainController {

    @RequestMapping(value = "/")
    public String acceuil(@CookieValue(value = "userId", defaultValue = "") String userId){
        if(Objects.equals(userId, "")){
            return "redirect:connexion";
        }else{
            return "connected";
        }
    }

    @RequestMapping(value = "/disconnect")
    public String disconnect(HttpServletResponse response){
        Cookie cookie = new Cookie("userId", null);
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        return "/connexion";
    }
}
