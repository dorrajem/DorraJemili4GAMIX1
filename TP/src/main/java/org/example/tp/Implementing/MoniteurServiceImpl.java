package org.example.tp.Implementing;

import org.example.tp.Entities.Moniteur;
import org.example.tp.Repositories.MoniteurRepository;
import org.example.tp.Services.IMoniteurService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MoniteurServiceImpl implements IMoniteurService {

    private static final Logger log = LoggerFactory.getLogger(MoniteurServiceImpl.class);

    public MoniteurServiceImpl(MoniteurRepository moniteurRepository) {
        this.moniteurRepository = moniteurRepository;
    }

    private final MoniteurRepository moniteurRepository;

    @Override
    public Moniteur addMoniteur(Moniteur moniteur) {
        log.info("Received Moniteur: {}", moniteur); // This will show nulls if not mapped
        return moniteurRepository.save(moniteur);
    }

    @Override
    public Moniteur updateMoniteur(Moniteur moniteur) {
        return moniteurRepository.save(moniteur);
    }

    @Override
    public Moniteur retrieveMoniteur(Long numMoniteur) {
        return moniteurRepository.findById(numMoniteur).orElse(null);
    }

    @Override
    public List<Moniteur> retrieveAllMoniteurs() {
        return moniteurRepository.findAll();
    }
}
