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

}
