package fr.isep.homeexchangemanager.controller;

import fr.isep.homeexchangemanager.dao.UserRepository;
import fr.isep.homeexchangemanager.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

@Controller
public class UserController {

    @Autowired
    UserRepository userDao;


    @RequestMapping(value = "profile")
    public String editProfile(
            HttpServletRequest request,
            Model model
    ){
        String userId = (String) request.getSession().getAttribute("userId");
        if(Objects.equals(userId, "") || userDao.findById(Long.valueOf(userId)).isEmpty()){return "redirect:/";}

        User user = userDao.findById(Long.valueOf(userId)).orElse(null);
        model.addAttribute("user", user);
        return "profile";
    }
}
