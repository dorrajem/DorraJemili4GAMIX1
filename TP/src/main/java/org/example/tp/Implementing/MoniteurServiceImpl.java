package org.example.tp.Implementing;

import org.example.tp.Entities.Cours;
import org.example.tp.Entities.Moniteur;
import org.example.tp.Repositories.CoursRepository;
import org.example.tp.Repositories.MoniteurRepository;
import org.example.tp.Repositories.PisteRepository;
import org.example.tp.Services.IMoniteurService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class MoniteurServiceImpl implements IMoniteurService {

    private static final Logger log = LoggerFactory.getLogger(MoniteurServiceImpl.class);

    public MoniteurServiceImpl(MoniteurRepository moniteurRepository, CoursRepository coursRepository) {
        this.moniteurRepository = moniteurRepository;
        this.coursRepository = coursRepository;

    }

    private final MoniteurRepository moniteurRepository;

    private final CoursRepository coursRepository;

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
    @Override
    public void removeMoniteur(Long numMoniteur) {moniteurRepository.deleteById(numMoniteur);}
    @Override
    public Moniteur addInstructorAndAssignToCourse(Moniteur moniteur, Long numCourse) {
        Cours cours = coursRepository.findById(numCourse).orElseThrow(() ->
                new NoSuchElementException("Cours introuvable: " + numCourse));
        Moniteur saved = moniteurRepository.save(moniteur);
        coursRepository.save(cours);
        return saved;
    }
}
