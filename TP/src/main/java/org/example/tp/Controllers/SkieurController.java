package org.example.tp.Controllers;


import org.example.tp.Entities.Skieur;
import org.example.tp.Enum.TypeAbonnement;
import org.example.tp.Services.ISkieurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class SkieurController
{
    public SkieurController(ISkieurService skieurService) {
        SkieurService = skieurService;
    }
    @Autowired
    private final ISkieurService SkieurService;

    @PostMapping("/addSkieur" )
    public Skieur addSkieur(@RequestBody Skieur Skieur) {
        return SkieurService.addSkieur(Skieur);
    }
    @PutMapping("/deleteSkieur" )
    public void deleteSkieur(@RequestBody Long numSkieur) {
       SkieurService.removeSkieur(numSkieur);
    }

    @GetMapping("/getSkieur/{numSkieur}" )
    public Skieur getSkieurBy(@PathVariable Long numSkieur) {
        return SkieurService.retrieveSkieur(numSkieur);
    }

    @GetMapping("/getAllSkieurs" )
    public java.util.List<Skieur> getAllSkieurs() {
        return SkieurService.retrieveAllSkieurs();
    }
    @PutMapping("/skiers/{numSkieur}/pistes/{numPiste}")
    public Skieur assignSkieurToPiste(
            @PathVariable Long numSkieur,
            @PathVariable Long numPiste) {
        return SkieurService.assignSkieurToPiste(numSkieur, numPiste);
    }
    @PostMapping("/skiers/cours/{numCourse}")
    public Skieur addSkierAndAssignToCourse(
            @RequestBody Skieur skieur,
            @PathVariable Long numCourse) {
        return SkieurService.addSkierAndAssignToCourse(skieur, numCourse);
    }

    // Récupérer les skieurs par type d'abonnement
    @GetMapping("/skiers/abonnement/{typeAbonnement}")
    public List<Skieur> retrieveSkiersBySubscriptionType(@PathVariable TypeAbonnement typeAbonnement) {
        return SkieurService.retrieveSkiersBySubscriptionType(typeAbonnement);
    }
}
