package tn.esprit.dorrajemili4gamix1.Services;

import tn.esprit.dorrajemili4gamix1.Entity.Chambre;

import java.util.List;

public interface IChambreService {
    Chambre ajouterChambre(Chambre chambre);
    Chambre modifierChambre(Chambre chambre);
    void supprimerChambre(Long id);
    Chambre getChambre(Long id);
    List<Chambre> getChambres();

}
