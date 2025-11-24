package org.example.tp.Controllers;


import org.example.tp.Entities.Abonnement;
import org.example.tp.Services.IAbonnementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController

public class AbonnementController
{
    public AbonnementController(IAbonnementService abonnementService) {
        AbonnementService = abonnementService;
    }
    @Autowired
    private final IAbonnementService AbonnementService;

    @PostMapping("/addAbonnement" )
    public Abonnement addAbonnement(@RequestBody Abonnement Abonnement) {
        return AbonnementService.addAbonnement(Abonnement);
    }
    @PutMapping("/deleteAbonnement" )
    public void deleteAbonnement(@RequestBody Long numAbonnement) {
       AbonnementService.removeAbonnement(numAbonnement);
    }

    @GetMapping("/getAbonnement/{numAbonnement}" )
    public Abonnement getAbonnementBy(@PathVariable Long numAbonnement) {
        return AbonnementService.retrieveAbonnement(numAbonnement);
    }

    @GetMapping("/getAllAbonnements" )
    public java.util.List<Abonnement> getAllAbonnements() {
        return AbonnementService.retrieveAllAbonnements();
    }

}
