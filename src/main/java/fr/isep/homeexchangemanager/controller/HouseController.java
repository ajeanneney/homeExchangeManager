package fr.isep.homeexchangemanager.controller;

import fr.isep.homeexchangemanager.dao.*;
import fr.isep.homeexchangemanager.entities.*;
import fr.isep.homeexchangemanager.utils.FileUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Controller
public class HouseController {

    @Autowired
    private UserRepository userDao;
    @Autowired
    private HouseRepository houseDao;
    @Autowired
    private PhotoRepository photoDao;

    @Autowired
    private ServiceRepository serviceDao;

    @Autowired
    private NecessityRepository necessityDao;

    @GetMapping("/house/{id}")
    public String viewHouse(
            HttpServletRequest request,
            @PathVariable(value = "id") String houseId,
            Model model
    ){
        String userId = (String) request.getSession().getAttribute("userId");
        if(userId == null || userDao.findById(Long.valueOf(userId)).isEmpty()){return "redirect:/";} //si pas connecté retour page connexion

        House house = houseDao.findById(Long.valueOf(houseId)).orElse(null);

        model.addAttribute("house", house);

        return "viewhouse";
    }


    @RequestMapping(value = "/newhouse")
    public String newHouse(
            HttpServletRequest request,
            @RequestParam(name = "title", defaultValue = "") String title,
            @RequestParam(name = "description", defaultValue = "") String description,
            @RequestParam(name = "photos", required = false) MultipartFile[] photos,
            @RequestParam(name = "necessities", required = false) Long[] necessities,
            @RequestParam(name = "services", required = false) Long[] services,
            Model model) throws IOException {

        String userId = (String) request.getSession().getAttribute("userId");
        if(userId == null || userDao.findById(Long.valueOf(userId)).isEmpty()){return "redirect:/";} //si pas connecté retour page connexion

        if(!Objects.equals(title, "") && !Objects.equals(description, "")){

            List<Necessity> houseNecessities =
                    Arrays.stream(necessities).map(n->{
                        return necessityDao.findById(n).orElse(null);
                    }).collect(Collectors.toList());

            List<Service> houseServices =
                    Arrays.stream(services).map(n->{
                        return serviceDao.findById(n).orElse(null);
                    }).collect(Collectors.toList());

            User user = userDao.findById(Long.parseLong(userId)).orElse(null);
            House house = new House(
                    user,
                    title,
                    description,
                    houseServices,
                    houseNecessities
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

        List<Service> serviceList = serviceDao.findAll();
        model.addAttribute("services", serviceList);

        List<Necessity> necessityList = necessityDao.findAll();
        model.addAttribute("necessities", necessityList);

        return "newhouse";
    }
}