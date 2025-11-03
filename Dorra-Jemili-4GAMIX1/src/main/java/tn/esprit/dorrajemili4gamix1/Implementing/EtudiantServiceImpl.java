package tn.esprit.dorrajemili4gamix1.Implementing;

import org.springframework.stereotype.Service;
import tn.esprit.dorrajemili4gamix1.Entity.Etudiant;
import tn.esprit.dorrajemili4gamix1.Repository.EtudiantRepository;
import tn.esprit.dorrajemili4gamix1.Services.IEtudiantService;

import java.util.List;


@Service
public class EtudiantServiceImpl implements IEtudiantService {
    public EtudiantServiceImpl(EtudiantRepository etudiantRepository) {
        this.etudiantRepository = etudiantRepository;
    }

    private final EtudiantRepository etudiantRepository;

    @Override
    public Etudiant ajouterEtudiant(Etudiant etudiant) {
        return etudiantRepository .save(etudiant);
    }

    @Override
    public Etudiant modifierEtudiant(Etudiant etudiant) {
        return etudiantRepository .save(etudiant);
    }

    @Override
    public void supprimerEtudiant(Long id) {
        etudiantRepository.deleteById(id);
    }

    @Override
    public Etudiant getEtudiant(Long id) {
        return etudiantRepository.findById(id).orElse(null);
    }

    @Override
    public List<Etudiant> getEtudiants() {
        return etudiantRepository.findAll();
    }
}
