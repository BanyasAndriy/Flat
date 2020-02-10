package ua.kiev.prog.oauth2.loginviagoogle.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ua.kiev.prog.oauth2.loginviagoogle.model.Citizen;
import ua.kiev.prog.oauth2.loginviagoogle.model.Flat;
import ua.kiev.prog.oauth2.loginviagoogle.services.GeneralService;

import java.util.ArrayList;
import java.util.List;


@Controller
public class MainController {


    @Autowired
    GeneralService generalService;

    @RequestMapping(value="/")
    String getMenu(){
        return "menu";
    }


    @RequestMapping(value="/addFlat")
    String addFlat(){
        return "addFlat";
    }

    @RequestMapping(value="/addResidents")
    String addCitizen(){
        return "addResidents";
    }

    @RequestMapping(value="/infoAboutFlat")
    String getInfo(){
        return "infoAboutFlat";
    }


@GetMapping(value="/registrationFlat")
public ModelAndView registrationFlat(@RequestParam String address , Model model){

    ModelAndView mod = new ModelAndView("/addFlat");
        Flat flat = new Flat(address);
        generalService.saveFlat(flat);

long id = flat.getId();


  mod.addObject("id",id);
    return mod;
    }

    @GetMapping(value="/registrationResident")
    String registrationResident(@RequestParam("idFlat") Long idFlat,
                                @RequestParam("resident") String resident
                                 ){

        List<Citizen> list = new ArrayList<>();
        list.add(new Citizen(resident));

        Flat flat = generalService.getFlatById(idFlat);
        flat.setCitizens(list);

        generalService.saveFlat(flat);
generalService.saveCitizen(new Citizen(resident,flat));

        return "redirect:/";
    }

    @GetMapping(value="/information")
    ModelAndView information(@RequestParam("idFlat") Long idFlat,Model model){

        ModelAndView mod = new ModelAndView("/infoAboutFlat");
        Flat flat = generalService.getFlatById(idFlat);


mod.addObject("address",flat.getAddress());
mod.addObject("citizen", generalService.getCitizenByFlatId(idFlat));

        return mod;
    }

}
