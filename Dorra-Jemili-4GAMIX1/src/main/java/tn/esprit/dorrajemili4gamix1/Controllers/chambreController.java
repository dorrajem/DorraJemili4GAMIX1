package tn.esprit.dorrajemili4gamix1.Controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.dorrajemili4gamix1.Entity.Chambre;
import tn.esprit.dorrajemili4gamix1.Services.IChambreService;

@RestController

public class chambreController {
    public chambreController(IChambreService chambreService) {
        this.chambreService = chambreService;
    }

    private final IChambreService chambreService;

    @PostMapping("/addChambre")
    public Chambre ajouterChambre(@RequestBody Chambre chambre) {
        return chambreService.ajouterChambre(chambre);
    }

    @PutMapping("/updateChambre" )
    public Chambre modifierChambre(@RequestBody Chambre chambre) {
        return chambreService.modifierChambre(chambre);
    }

    @DeleteMapping("/deleteChambre/{idChambre}" )
    public void supprimerChambre(@RequestParam Long idChambre) {
        chambreService.supprimerChambre(idChambre);
    }

    @GetMapping("getChambre/{idChambre}")
    public Chambre getChambre(@RequestParam Long idChambre) {
        return chambreService.getChambre(idChambre);
    }

    @GetMapping("/getAllChambres")
    public java.util.List<Chambre> getAllChambre() {
        return chambreService.getChambres();
    }
}
