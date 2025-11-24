package org.example.tp.Controllers;


import org.example.tp.Entities.Inscription;
import org.example.tp.Services.IInscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController

public class InscriptionController
{
    public InscriptionController(IInscriptionService inscriptionService) {
        InscriptionService = inscriptionService;
    }
    @Autowired
    private final IInscriptionService InscriptionService;

    @PostMapping("/addInscription" )
    public Inscription addInscription(@RequestBody Inscription Inscription) {
        return InscriptionService.addInscription(Inscription);
    }
    @PutMapping("/deleteInscription" )
    public void deleteInscription(@RequestBody Long numInscription) {
       InscriptionService.removeInscription(numInscription);
    }

    @GetMapping("/getInscription/{numInscription}" )
    public Inscription getInscriptionBy(@PathVariable Long numInscription) {
        return InscriptionService.retrieveInscription(numInscription);
    }

    @GetMapping("/getAllInscriptions" )
    public java.util.List<Inscription> getAllInscriptions() {
        return InscriptionService.retrieveAllInscriptions();
    }
    @PostMapping("/inscriptions/skieur/{numSkieur}")
    public Inscription addRegistrationAndAssignToSkieur(
            @RequestBody Inscription inscription,
            @PathVariable Long numSkieur) {
        return InscriptionService.addRegistrationAndAssignToSkier(inscription, numSkieur);
    }

    // Affecter une inscription à un cours
    @PutMapping("/inscriptions/{numRegistration}/cours/{numCourse}")
    public Inscription assignRegistrationToCourse(
            @PathVariable Long numRegistration,
            @PathVariable Long numCourse) {
        return InscriptionService.assignRegistrationToCourse(numRegistration, numCourse);
    }

    @PostMapping("/inscriptions/skieur/{numSkieur}/cours/{numCours}")
    public Inscription addRegistrationAndAssignToSkierAndCourse(
            @RequestBody Inscription inscription,
            @PathVariable Long numSkieur,
            @PathVariable Long numCours) {
        return InscriptionService.addRegistrationAndAssignToSkierAndCourse(inscription, numSkieur, numCours);
    }

}
