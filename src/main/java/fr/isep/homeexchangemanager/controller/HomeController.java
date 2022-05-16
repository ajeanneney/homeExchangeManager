package fr.isep.homeexchangemanager.controller;

import fr.isep.homeexchangemanager.dao.HouseRepository;
import fr.isep.homeexchangemanager.dao.UserRepository;
import fr.isep.homeexchangemanager.entities.House;
import fr.isep.homeexchangemanager.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletRequest;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@Controller
public class HomeController {

    @Autowired
    private UserRepository userDao;
    @Autowired
    private HouseRepository houseDao;

    @RequestMapping(value = "/newhome")
    public String newHome(
            @CookieValue(value = "userId", defaultValue = "") String userId,
            ServletRequest request){

        if(Objects.equals(userId, "") || userDao.findById(Long.valueOf(userId)).isEmpty()){return "redirect:connexion";} //si pas connecté retour page connexion

        System.out.println("coucouc2");
        Map<String, String[]> paramMap = request.getParameterMap();
        if(paramMap.containsKey("title") && paramMap.containsKey("description")){
            System.out.println("coucou");
            User user = userDao.findById(Long.parseLong(userId)).orElse(null);
            House house = new House(
                    user,
                    paramMap.get("title")[0],
                    paramMap.get("description")[0]
            );
            houseDao.save(house);
        }


        return "newhome";
    }
}