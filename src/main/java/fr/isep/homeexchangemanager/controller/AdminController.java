package fr.isep.homeexchangemanager.controller;

import fr.isep.homeexchangemanager.dao.NecessityRepository;
import fr.isep.homeexchangemanager.dao.ServiceRepository;
import fr.isep.homeexchangemanager.dao.UserRepository;
import fr.isep.homeexchangemanager.entities.Necessity;
import fr.isep.homeexchangemanager.entities.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

@Controller
public class AdminController {

    @Autowired
    UserRepository userDao;

    @Autowired
    ServiceRepository serviceDao;

    @Autowired
    NecessityRepository necessityDao;


    @RequestMapping(value = "/admin")
    public String admin(
            HttpServletRequest request,
            Model model,
            @RequestParam(value = "type", defaultValue = "") String type,
            @RequestParam(value = "title", defaultValue = "") String title,
            @RequestParam(value = "description", defaultValue = "") String description
    ){
        String userId = (String) request.getSession().getAttribute("userId");
        boolean isAdmin = false;
        if(request.getSession().getAttribute("isAdmin") == null || !((boolean) request.getSession().getAttribute("isAdmin"))) {
            return "redirect:/";
        }
        if(userId == null || userDao.findById(Long.valueOf(userId)).isEmpty()){return "redirect:/";} //si pas connecté retour page connexion

        if(!Objects.equals(type, "") && !Objects.equals(title, "") && !Objects.equals(description, "")){
            if(Objects.equals(type, "necessity")){
                necessityDao.save(new Necessity(title, description));
            } else if (Objects.equals(type, "service")) {
                serviceDao.save(new Service(title, description));
            }
        }

        model.addAttribute("users", userDao.findAll());

        return "admin";
    }

    @RequestMapping(value = "/admin/delete/{id}")
    public String deleteUser(
            @PathVariable(value = "id") String userToDelete,
            HttpServletRequest request
    ){
        String userId = (String) request.getSession().getAttribute("userId");
        boolean isAdmin = false;
        if(request.getSession().getAttribute("isAdmin") == null || !((boolean) request.getSession().getAttribute("isAdmin"))) {
            return "redirect:/";
        }
        if(userId == null || userDao.findById(Long.valueOf(userId)).isEmpty()){return "redirect:/";} //si pas connecté retour page connexion

        userDao.deleteById(Long.valueOf(userToDelete));

        return "redirect:/admin";

    }
}
