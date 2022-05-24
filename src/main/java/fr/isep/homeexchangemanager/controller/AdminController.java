package fr.isep.homeexchangemanager.controller;

import fr.isep.homeexchangemanager.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AdminController {

    @Autowired
    UserRepository userDao;

    @RequestMapping(value = "/admin")
    public String admin(
            HttpServletRequest request
    ){
        String userId = (String) request.getSession().getAttribute("userId");
        boolean isAdmin = false;
        if(request.getSession().getAttribute("isAdmin") == null || !((boolean) request.getSession().getAttribute("isAdmin"))) {
            return "redirect:/";
        }
        if(userId == null || userDao.findById(Long.valueOf(userId)).isEmpty()){return "redirect:/";} //si pas connecté retour page connexion

        return "admin";
    }
}
