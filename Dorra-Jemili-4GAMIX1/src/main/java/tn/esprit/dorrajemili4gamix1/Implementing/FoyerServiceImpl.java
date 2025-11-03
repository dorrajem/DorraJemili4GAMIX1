package tn.esprit.dorrajemili4gamix1.Implementing;

import org.springframework.stereotype.Service;
import tn.esprit.dorrajemili4gamix1.Entity.Foyer;
import tn.esprit.dorrajemili4gamix1.Repository.FoyerRepository;
import tn.esprit.dorrajemili4gamix1.Services.IFoyerService;
import java.util.List;


@Service
public class FoyerServiceImpl implements IFoyerService {
    public FoyerServiceImpl(FoyerRepository foyerRepository) {
        this.foyerRepository = foyerRepository;
    }

    private final FoyerRepository foyerRepository;
    @Override
    public Foyer ajouterFoyer(Foyer foyer) {
        return foyerRepository.save(foyer);
    }

    @Override
    public Foyer modifierFoyer(Foyer foyer) {
        return foyerRepository.save(foyer);
    }

    @Override
    public void supprimerEtudiant(Long id) {
        foyerRepository.deleteById(id);
    }

    @Override
    public Foyer getFoyer(Long id) {
        return foyerRepository.findById(id).orElse(null);
    }

    @Override
    public List<Foyer> getFoyers() {
        return foyerRepository.findAll();
    }
}
