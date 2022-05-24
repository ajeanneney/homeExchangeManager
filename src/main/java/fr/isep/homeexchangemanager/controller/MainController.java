package fr.isep.homeexchangemanager.controller;

import fr.isep.homeexchangemanager.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

@Controller
public class MainController {

    @Autowired
    private UserRepository userDao;

    @RequestMapping(value = "/")
    public String acceuil(HttpServletRequest request){
        String userId = (String) request.getSession().getAttribute("userId");

        if(userId == null || userDao.findById(Long.valueOf(userId)).isEmpty()){return "redirect:/connexion";}
        else{
            return "redirect:home";
        }
    }

    @RequestMapping(value = "/disconnect")
    public String disconnect(HttpServletRequest request){
        request.getSession().invalidate();
        return "redirect:/";
    }
}
