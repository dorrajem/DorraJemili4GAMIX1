package tn.esprit.dorrajemili4gamix1.Services;

import tn.esprit.dorrajemili4gamix1.Entity.Universite;

import java.util.List;

public interface IUniversiteService {
    Universite ajouUniversite(Universite universite);
    Universite modifierUniversite(Universite universite);
    void supprimerUniversite(Long id);
    Universite getUniversite(Long id);
    List<Universite> getUniversites();
}
