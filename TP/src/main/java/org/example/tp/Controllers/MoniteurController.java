package org.example.tp.Controllers;


import org.example.tp.Entities.Moniteur;
import org.example.tp.Services.IMoniteurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController

public class MoniteurController
{
    public MoniteurController(IMoniteurService moniteurService) {
        MoniteurService = moniteurService;
    }
    @Autowired
    private final IMoniteurService MoniteurService;

    @PostMapping("/addMoniteur" )
    public Moniteur addMoniteur(@RequestBody Moniteur Moniteur) {
        return MoniteurService.addMoniteur(Moniteur);
    }
    @PutMapping("/updateMoniteur" )
    public Moniteur updateBloc(@RequestBody Moniteur Moniteur) {
        return MoniteurService.updateMoniteur(Moniteur);
    }

    @GetMapping("/getMoniteur/{numMoniteur}" )
    public Moniteur getBlocBy(@PathVariable Long numMoniteur) {
        return MoniteurService.retrieveMoniteur(numMoniteur);
    }

    @GetMapping("/getAllMoniteurs" )
    public java.util.List<Moniteur> getAllMoniteurs() {
        return MoniteurService.retrieveAllMoniteurs();
    }
    @PutMapping("/deleteMoniteur" )
    public void deleteMoniteur(@RequestBody Long numMoniteur) {
        MoniteurService.removeMoniteur(numMoniteur);
    }
    @PostMapping("/moniteurs/cours/{numCourse}")
    public Moniteur addInstructorAndAssignToCourse(
            @RequestBody Moniteur moniteur,
            @PathVariable Long numCourse) {
        return MoniteurService.addInstructorAndAssignToCourse(moniteur, numCourse);
    }

}
