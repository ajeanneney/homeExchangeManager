package fr.isep.homeexchangemanager.controller;

import fr.isep.homeexchangemanager.dao.UserRepository;
import fr.isep.homeexchangemanager.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

@Controller
public class UserController {

    @Autowired
    UserRepository userDao;


    @RequestMapping(value = "profile")
    public String editProfile(
            HttpServletRequest request,
            Model model,
            @RequestParam(value = "firstname", defaultValue = "") String firstname,
            @RequestParam(value = "lastname", defaultValue = "") String lastname,
            @RequestParam(value = "mail", defaultValue = "") String mail,
            @RequestParam(value = "password", defaultValue = "") String password
    ){
        String userId = (String) request.getSession().getAttribute("userId");
        if(userId == null || userDao.findById(Long.valueOf(userId)).isEmpty()){return "redirect:/";}

        User user = userDao.getById(Long.valueOf(userId));
        model.addAttribute("user", user);

        if(!Objects.equals(firstname, "")){
            user.setFirstname(firstname);
        }
        if(!Objects.equals(lastname, "")){
            user.setLastname(lastname);
        }
        if(!Objects.equals(mail, "mail")){
            user.setMail(mail);
        }
        if(!Objects.equals(password, "")){
            user.setPassword(password);
        }
        userDao.save(user);
        return "profile";
    }
}
