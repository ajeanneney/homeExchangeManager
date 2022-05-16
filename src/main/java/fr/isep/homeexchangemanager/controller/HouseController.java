package fr.isep.homeexchangemanager.controller;

import fr.isep.homeexchangemanager.dao.HouseRepository;
import fr.isep.homeexchangemanager.dao.UserRepository;
import fr.isep.homeexchangemanager.entities.House;
import fr.isep.homeexchangemanager.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletRequest;
import java.util.Map;
import java.util.Objects;

@Controller
public class HouseController {

    @Autowired
    private UserRepository userDao;
    @Autowired
    private HouseRepository houseDao;

    @RequestMapping(value = "/newhouse")
    public String newHouse(
            @CookieValue(value = "userId", defaultValue = "") String userId,
            ServletRequest request){

        if(Objects.equals(userId, "") || userDao.findById(Long.valueOf(userId)).isEmpty()){return "redirect:connexion";} //si pas connecté retour page connexion

        Map<String, String[]> paramMap = request.getParameterMap();
        if(paramMap.containsKey("title") && paramMap.containsKey("description")){
            User user = userDao.findById(Long.parseLong(userId)).orElse(null);
            House house = new House(
                    user,
                    paramMap.get("title")[0],
                    paramMap.get("description")[0]
            );
            houseDao.save(house);
        }


        return "newhouse";
    }
}