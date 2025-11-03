package tn.esprit.dorrajemili4gamix1.Services;

import tn.esprit.dorrajemili4gamix1.Entity.Foyer;

import java.util.List;

public interface IFoyerService {
    Foyer ajouterFoyer(Foyer foyer);
    Foyer modifierFoyer(Foyer foyer);
    void supprimerEtudiant(Long id);
    Foyer getFoyer(Long id);
    List<Foyer> getFoyers();

}
