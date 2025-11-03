package tn.esprit.dorrajemili4gamix1.Controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.dorrajemili4gamix1.Entity.Etudiant;
import tn.esprit.dorrajemili4gamix1.Services.IEtudiantService;

@AllArgsConstructor
@RestController

public class EtudiantController {
    private final IEtudiantService etudiantService;

    @PostMapping("/addEtudiant")
    public Etudiant addEtudiant(@RequestBody Etudiant etudiant) {
        return etudiantService.ajouterEtudiant(etudiant);
    }

    @PutMapping("/updateEtudiant")
    public Etudiant updateEtudiant(@RequestBody Etudiant etudiant) {
        return etudiantService.modifierEtudiant(etudiant);
    }

    @DeleteMapping
    public void deleteEtudiant(@RequestParam Long idEtudiant) {
        etudiantService.supprimerEtudiant(idEtudiant);
    }

    @GetMapping("/getEtudiant")
    public Etudiant getEtudiant(@RequestParam Long idEtudiant) {
        return etudiantService.getEtudiant(idEtudiant);
    }

    @GetMapping("/getAllEtudiants")
    public java.util.List<Etudiant> getAllEtudiants() {
        return etudiantService.getEtudiants();
    }
}
