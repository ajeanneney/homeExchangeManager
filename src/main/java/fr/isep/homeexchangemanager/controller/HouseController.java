package fr.isep.homeexchangemanager.controller;

import fr.isep.homeexchangemanager.dao.HouseRepository;
import fr.isep.homeexchangemanager.dao.PhotoRepository;
import fr.isep.homeexchangemanager.dao.UserRepository;
import fr.isep.homeexchangemanager.entities.House;
import fr.isep.homeexchangemanager.entities.Photo;
import fr.isep.homeexchangemanager.entities.User;
import fr.isep.homeexchangemanager.utils.FileUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;

@Controller
public class HouseController {

    @Autowired
    private UserRepository userDao;
    @Autowired
    private HouseRepository houseDao;
    @Autowired
    private PhotoRepository photoDao;

    @RequestMapping(value = "/newhouse")
    public String newHouse(
            @CookieValue(value = "userId", defaultValue = "") String userId,
            @RequestParam(name = "title", defaultValue = "") String title,
            @RequestParam(name = "description", defaultValue = "") String description,
            @RequestParam(name = "photos", required = false) MultipartFile[] photos,
            ServletRequest request) throws IOException {
        if(Objects.equals(userId, "") || userDao.findById(Long.valueOf(userId)).isEmpty()){return "redirect:connexion";} //si pas connecté retour page connexion

        if(!Objects.equals(title, "") && !Objects.equals(description, "")){

            User user = userDao.findById(Long.parseLong(userId)).orElse(null);
            House house = new House(
                    user,
                    title,
                    description
            );
            House newHouse = houseDao.saveAndFlush(house);

            int counter = 0;
            for (MultipartFile photo : photos) {
                String filename = "user" + userId + "_house" + newHouse.getId().toString() + "_" + counter + StringUtils.cleanPath(Objects.requireNonNull(photo.getOriginalFilename()));
                photoDao.save(new Photo(newHouse, filename));

                FileUploadUtil.saveFile("src/main/resources/static/images/housephotos", filename, photo);
                counter++;
            }

        }


        return "newhouse";
    }
}