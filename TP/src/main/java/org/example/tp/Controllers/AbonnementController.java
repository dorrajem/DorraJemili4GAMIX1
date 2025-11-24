package org.example.tp.Controllers;


import org.example.tp.Entities.Abonnement;
import org.example.tp.Enum.TypeAbonnement;
import org.example.tp.Services.IAbonnementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

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
    @GetMapping("/abonnements/type/{type}")
    public Set<Abonnement> getSubscriptionByType(@PathVariable TypeAbonnement type) {
        return AbonnementService.getSubscriptionByType(type);
    }

    // Récupérer les abonnements entre deux dates
    @GetMapping("/abonnements/dates")
    public List<Abonnement> retrieveSubscriptionsByDates(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate start,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate end) {
        return AbonnementService.retrieveSubscriptionsByDates(start, end);
    }

}
