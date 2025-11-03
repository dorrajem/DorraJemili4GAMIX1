package tn.esprit.dorrajemili4gamix1.Implementing;

import org.springframework.stereotype.Service;
import tn.esprit.dorrajemili4gamix1.Entity.Universite;
import tn.esprit.dorrajemili4gamix1.Repository.BlocRepository;
import tn.esprit.dorrajemili4gamix1.Repository.UniversiteRepository;
import tn.esprit.dorrajemili4gamix1.Services.IUniversiteService;

import java.util.List;

@Service
public class UniversiteServiceImpl implements IUniversiteService {
    public UniversiteServiceImpl(UniversiteRepository universiteRepository) {
        this.universiteRepository = universiteRepository;
    }

    private final UniversiteRepository universiteRepository;

    @Override
    public Universite ajouUniversite(Universite universite) {
        return universiteRepository.save(universite);
    }

    @Override
    public Universite modifierUniversite(Universite universite) {
        return universiteRepository.save(universite);
    }

    @Override
    public void supprimerUniversite(Long id) {
        universiteRepository.deleteById(id);
    }

    @Override
    public Universite getUniversite(Long id) {
        return universiteRepository.findById(id).orElse(null);
    }

    @Override
    public List<Universite> getUniversites() {
        return universiteRepository.findAll();
    }
}
