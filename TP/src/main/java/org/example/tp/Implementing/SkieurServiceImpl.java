package org.example.tp.Implementing;

import org.example.tp.Entities.Cours;
import org.example.tp.Entities.Inscription;
import org.example.tp.Entities.Piste;
import org.example.tp.Entities.Skieur;
import org.example.tp.Enum.TypeAbonnement;
import org.example.tp.Repositories.SkieurRepository;
import org.example.tp.Services.ISkieurService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.example.tp.Repositories.InscriptionRepository;
import org.example.tp.Repositories.CoursRepository;
import org.example.tp.Repositories.PisteRepository;

import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class SkieurServiceImpl implements ISkieurService {
    private static final Logger log = LoggerFactory.getLogger(SkieurServiceImpl.class);

    private final SkieurRepository skieurRepository;
    private final CoursRepository coursRepository;
    private final InscriptionRepository inscriptionRepository;
    private final PisteRepository pisteRepository;

    public SkieurServiceImpl(SkieurRepository skieurRepository, CoursRepository coursRepository, InscriptionRepository inscriptionRepository, PisteRepository pisteRepository) {
        this.skieurRepository = skieurRepository;
        this.coursRepository = coursRepository;
        this.inscriptionRepository = inscriptionRepository;
        this.pisteRepository = pisteRepository;
    }

    @Override
    public Skieur addSkieur(Skieur skieur) {
        log.info("Received Skieur: {}", skieur); // This will show nulls if not mapped
        // Abonnement will be saved automatically because of CascadeType.ALL
        return skieurRepository.save(skieur);
    }

    @Override
    public void removeSkieur(Long numSkieur) {
        skieurRepository.deleteById(numSkieur);
        // Abonnement is deleted automatically
    }

    @Override
    public Skieur retrieveSkieur(Long numSkieur) {
        return skieurRepository.findById(numSkieur).orElse(null);
    }

    @Override
    public List<Skieur> retrieveAllSkieurs() {
        return skieurRepository.findAll();
    }
    @Override
    public Skieur assignSkieurToPiste(Long numSkieur, Long numPiste) {
        Skieur sk = skieurRepository.findById(numSkieur).orElseThrow(() ->
                new NoSuchElementException("Skieur introuvable: " + numSkieur));
        Piste p = pisteRepository.findById(numPiste).orElseThrow(() ->
                new NoSuchElementException("Piste introuvable: " + numPiste));
        if (sk.getPistes() == null) sk.setPistes(new HashSet<>());
        sk.getPistes().add(p);
        // si relation bidirectionnelle, ajoute aussi sk à p.getSkieurs() si existant
        return skieurRepository.save(sk);
    }
    @Override
    public Skieur addSkierAndAssignToCourse(Skieur skieur, Long numCourse) {
        // on enregistre le skieur (sauvegarde abonnement via cascade si présent)
        Skieur savedSkieur = skieurRepository.save(skieur);

        // création d'une inscription et affectation au cours
        Cours cours = coursRepository.findById(numCourse).orElseThrow(() ->
                new NoSuchElementException("Cours introuvable: " + numCourse));

        Inscription ins = new Inscription();
        ins.setSkieur(savedSkieur);
        ins.setCours(cours);
        // set d'autres champs d'Inscription si besoin
        inscriptionRepository.save(ins);

        return savedSkieur;
    }

    @Override
    public List<Skieur> retrieveSkiersBySubscriptionType(TypeAbonnement typeAbonnement) {
        // Nécessite méthode custom sur repo: findByAbonnementTypeAbon(...)
        return skieurRepository.findByAbonnementTypeAbon(typeAbonnement);
    }

}

