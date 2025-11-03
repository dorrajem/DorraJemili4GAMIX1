package tn.esprit.dorrajemili4gamix1.Controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.dorrajemili4gamix1.Entity.Foyer;
import tn.esprit.dorrajemili4gamix1.Services.IFoyerService;

@RestController
@AllArgsConstructor

public class FoyerController {
    private final IFoyerService foyerService;

    @PostMapping("/addFoyer")
    public Foyer addFoyer(@RequestBody Foyer foyer) {
        return foyerService.ajouterFoyer(foyer);
    }

    @PutMapping("/updateFoyer")
    public Foyer updateFoyer(@RequestBody Foyer foyer) {
        return foyerService.modifierFoyer(foyer);
    }

    @DeleteMapping("/deleteFoyer/{id}")
    public void deleteFoyer(@PathVariable("id") Long idFoyer) {
        foyerService.supprimerEtudiant(idFoyer);
    }

    @GetMapping("/getFoyer/{id}")
    public Foyer getFoyer(@PathVariable("id") Long idFoyer) {
        return foyerService.getFoyer(idFoyer);
    }

    @GetMapping("/getAllFoyers")
    public java.util.List<Foyer> getAllFoyers() {
        return foyerService.getFoyers();
    }
}
