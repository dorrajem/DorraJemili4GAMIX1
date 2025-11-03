package tn.esprit.dorrajemili4gamix1.Services;

import tn.esprit.dorrajemili4gamix1.Entity.Etudiant;

import java.util.List;

public interface IEtudiantService {
    Etudiant ajouterEtudiant(Etudiant etudiant);
    Etudiant modifierEtudiant(Etudiant etudiant);
    void supprimerEtudiant(Long id);
    Etudiant getEtudiant(Long id);
    List<Etudiant> getEtudiants();

}
