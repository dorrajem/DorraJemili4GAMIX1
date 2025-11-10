package org.example.tp.Implementing;

import org.example.tp.Entities.Skieur;
import org.example.tp.Repositories.SkieurRepository;
import org.example.tp.Services.ISkieurService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkieurServiceImpl implements ISkieurService {

    private static final Logger log = LoggerFactory.getLogger(SkieurServiceImpl.class);

    public SkieurServiceImpl(SkieurRepository skieurRepository) {
        this.skieurRepository = skieurRepository;
    }

    private final SkieurRepository skieurRepository;

    @Override
    public Skieur addSkieur(Skieur skieur) {
        log.info("Received Skieur: {}", skieur); // This will show nulls if not mapped
        return skieurRepository.save(skieur);
    }

    @Override
    public void removeSkieur (Long numSkieur) {
         skieurRepository.deleteById(numSkieur);
    }

    @Override
    public Skieur retrieveSkieur(Long numSkieur) {
        return skieurRepository.findById(numSkieur).orElse(null);
    }

    @Override
    public List<Skieur> retrieveAllSkieurs() {
        return skieurRepository.findAll();
    }
}
