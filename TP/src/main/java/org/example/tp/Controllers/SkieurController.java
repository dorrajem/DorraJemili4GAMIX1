package org.example.tp.Controllers;


import org.example.tp.Entities.Skieur;
import org.example.tp.Services.ISkieurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

}
