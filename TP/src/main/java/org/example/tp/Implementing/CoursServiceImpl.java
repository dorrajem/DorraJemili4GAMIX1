package org.example.tp.Implementing;

import org.example.tp.Entities.Cours;
import org.example.tp.Entities.Moniteur;
import org.example.tp.Repositories.CoursRepository;
import org.example.tp.Repositories.MoniteurRepository;
import org.example.tp.Repositories.PisteRepository;
import org.example.tp.Enum.Support;
import org.example.tp.Services.ICoursService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class CoursServiceImpl implements ICoursService {

    private static final Logger log = LoggerFactory.getLogger(CoursServiceImpl.class);

    public CoursServiceImpl(CoursRepository coursRepository, MoniteurRepository moniteurRepository, PisteRepository pisteRepository) {
        this.coursRepository = coursRepository;
        this.moniteurRepository = moniteurRepository;
    }

    private final CoursRepository coursRepository;
    private final MoniteurRepository moniteurRepository;

    @Override
    public Cours addCours(Cours cours) {
        log.info("Received Cours: {}", cours);
        return coursRepository.save(cours);
    }

    @Override
    public Cours updateCours(Cours cours) {
        return coursRepository.save(cours);
    }

    @Override
    public Cours retrieveCours(Long numCours) {
        return coursRepository.findById(numCours).orElse(null);
    }

    @Override
    public List<Cours> retrieveAllCourses() {
        return coursRepository.findAll();
    }

    @Override
    public void removeCours(Long numCours) {coursRepository.deleteById(numCours);}

    @Override
    public List<Integer> numWeeksCourseOfInstructorBySupport(Long numInstructor, Support support) {
        Moniteur moniteur = moniteurRepository.findById(numInstructor).orElseThrow(() ->
                new NoSuchElementException("Moniteur introuvable: " + numInstructor));
        // Récupérer les cours du moniteur
        List<Cours> coursDuMoniteur = coursRepository.findByMoniteur(moniteur);

        // Filtrer par support et récupérer numSemaine (ou creneau) de chaque inscription/cours
        // Ici j'assume que Cours a champ 'creneau' ou 'numSemaine'
        return coursDuMoniteur.stream()
                .filter(c -> c.getSupport() == support)
                .map(Cours::getCrenaux) // ou getNumSemaine si tu as ce champ
                .distinct()
                .collect(Collectors.toList());
    }
}
