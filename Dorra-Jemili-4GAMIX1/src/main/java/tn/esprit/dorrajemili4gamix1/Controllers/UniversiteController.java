package tn.esprit.dorrajemili4gamix1.Controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.dorrajemili4gamix1.Entity.Universite;
import tn.esprit.dorrajemili4gamix1.Services.IUniversiteService;

@RestController

public class UniversiteController {
    public UniversiteController(IUniversiteService universiteService) {
        this.universiteService = universiteService;
    }

    private final IUniversiteService universiteService;

    @PostMapping("/addUniversite")
    public Universite addUniversite(@RequestBody Universite universite) {
        return universiteService.ajouUniversite(universite);
    }

    @PutMapping("/updateUniversite")
    public Universite updateUniversite(@RequestBody Universite universite) {
        return universiteService.modifierUniversite(universite);
    }

    @DeleteMapping("/deleteUniversite/{id}")
    public void deleteUniversite(@PathVariable Long id) {
        universiteService.supprimerUniversite(id);
    }

    @GetMapping("/getUniversite/{id}")
    public Universite getUniversite(@PathVariable Long id) {
        return universiteService.getUniversite(id);
    }

    @GetMapping("/getAllUniversites")
    public java.util.List<Universite> getAllUniversites() {
        return universiteService.getUniversites();
    }
}
