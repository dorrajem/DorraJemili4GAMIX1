package tn.esprit.dorrajemili4gamix1.Implementing;

import org.springframework.stereotype.Service;
import tn.esprit.dorrajemili4gamix1.Entity.Chambre;
import tn.esprit.dorrajemili4gamix1.Repository.ChambreRepository;
import tn.esprit.dorrajemili4gamix1.Services.IChambreService;

import java.util.List;


@Service
public class ChambreServiceImpl implements IChambreService {
    public ChambreServiceImpl(ChambreRepository chambreRepository) {
        this.chambreRepository = chambreRepository;
    }

    private final ChambreRepository chambreRepository;

    @Override
    public Chambre ajouterChambre(Chambre chambre) {
        return chambreRepository.save(chambre);
    }

    @Override
    public Chambre modifierChambre(Chambre chambre) {
        return chambreRepository.save(chambre);
    }

    @Override
    public void supprimerChambre(Long id) {
        chambreRepository.deleteById(id);
    }

    @Override
    public Chambre getChambre(Long id) {
        return chambreRepository.findById(id).orElse(null);
    }

    @Override
    public List<Chambre> getChambres() {
        return chambreRepository.findAll();
    }
}
