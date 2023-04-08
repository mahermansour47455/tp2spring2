package com.maher.section345.controllers;

import com.maher.section345.entities.Equipe;
import com.maher.section345.service.EquipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class EquipeController {

    @Autowired
    EquipeService equipeService;
    @RequestMapping("/showCreate")
    public String showCreate()
    {
        return "CreateEquipe";
    }
    @RequestMapping("/saveEquipe")
    public String saveEquipe(@ModelAttribute("equipe") Equipe equipe,
                              @RequestParam("date") String date,
                             @RequestParam (name="page",defaultValue = "0") int page,
                             @RequestParam (name="size", defaultValue = "2") int size,
                              ModelMap modelMap) throws
            ParseException
    {
//conversion de la date
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
        Date dateCreation = dateformat.parse(String.valueOf(date));
        equipe.setDateFound(dateCreation);

        Equipe saveEquipe = equipeService.saveEquipe(equipe);
        String msg ="produit enregistré avec Id "+saveEquipe.getIdEquipe();
        modelMap.addAttribute("msg", msg);
        Page <Equipe> equipes = equipeService.getAllEquipesParPage(page, size);
        modelMap.addAttribute("equipes", equipes);
        modelMap.addAttribute("pages", new int[equipes.getTotalPages()]);
        modelMap.addAttribute("currentPage", page);
        modelMap.addAttribute("size", size);
        int lastPage = equipeService.getAllEquipesParPage(0, size).getTotalPages() - 1;
        return "redirect:/ListeEquipe?page=" + lastPage + "&size=" + size;

    }

    @RequestMapping("/ListeEquipe")
    public String ListeEquipe(ModelMap modelMap,
                                @RequestParam (name="page",defaultValue = "0") int page,
                                @RequestParam (name="size", defaultValue = "2") int size)
    {
        Page <Equipe> equipes = equipeService.getAllEquipesParPage(page, size);
        modelMap.addAttribute("equipes", equipes);
        modelMap.addAttribute("pages", new int[equipes.getTotalPages()]);
        modelMap.addAttribute("currentPage", page);
        modelMap.addAttribute("size", size);
        return "ListeEquipe";


    }
    @RequestMapping("/supprimerEquipe")
    public String supprimerEquipe(@RequestParam("id") Long id,
                                ModelMap modelMap,
                                @RequestParam (name="page",defaultValue = "0") int page,
                                @RequestParam (name="size", defaultValue = "2") int size)
    {
        equipeService.deleteEquipeById(id);
        Page <Equipe> equipes = equipeService.getAllEquipesParPage(page, size);
        modelMap.addAttribute("equipes", equipes);
        modelMap.addAttribute("pages", new int[equipes.getTotalPages()]);
        modelMap.addAttribute("currentPage", page);
        modelMap.addAttribute("size", size);
        return "ListeEquipe";
    }
    @RequestMapping("/modifierEquipe")
    public String modifierEquipe(@RequestParam("id") Long id,
                                  ModelMap modelMap)
    {
        Equipe e = equipeService.getEquipe(id);
        modelMap.addAttribute("equipe", e);
        return "editerEquipe";
    }
    @RequestMapping("/updateEquipe")
    public String updateEquipe(@ModelAttribute("equipe") Equipe equipe,
                               @RequestParam("date") String date,
                               @RequestParam (name="page",defaultValue = "0") int page,
                               @RequestParam (name="size", defaultValue = "2") int size,
                               ModelMap modelMap) throws
            ParseException
    {
//conversion de la date
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
        Date dateCreation = dateformat.parse(String.valueOf(date));
        equipe.setDateFound(dateCreation);
        equipeService.updateEquipe(equipe);
        Page <Equipe> equipes = equipeService.getAllEquipesParPage(page, size);
        modelMap.addAttribute("equipes", equipes);
        modelMap.addAttribute("pages", new int[equipes.getTotalPages()]);
        modelMap.addAttribute("currentPage", page);
        modelMap.addAttribute("size", size);
        return "ListeEquipe";
    }


}
