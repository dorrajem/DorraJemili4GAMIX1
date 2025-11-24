package org.example.tp.Implementing;

import org.example.tp.Entities.Cours;
import org.example.tp.Entities.Inscription;
import org.example.tp.Entities.Skieur;
import org.example.tp.Repositories.CoursRepository;
import org.example.tp.Repositories.InscriptionRepository;
import org.example.tp.Repositories.SkieurRepository;
import org.example.tp.Services.IInscriptionService;
import org.example.tp.Implementing.SkieurServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class InscriptionServiceImpl implements IInscriptionService {

    private static final Logger log = LoggerFactory.getLogger(InscriptionServiceImpl.class);

    public InscriptionServiceImpl(InscriptionRepository InscriptionRepository, SkieurRepository skieurRepository, CoursRepository coursRepository) {
        this.InscriptionRepository = InscriptionRepository;
        this.skieurRepository = skieurRepository;
        this.coursRepository = coursRepository;
    }

    private final InscriptionRepository InscriptionRepository;

    private final SkieurRepository skieurRepository;

    private final CoursRepository coursRepository;

    @Override
    public Inscription addInscription(Inscription Inscription) {
        log.info("Received Inscription: {}", Inscription); // This will show nulls if not mapped
        return InscriptionRepository.save(Inscription);
    }

    @Override
    public void removeInscription (Long numInscription) {
         InscriptionRepository.deleteById(numInscription);
    }

    @Override
    public Inscription retrieveInscription(Long numInscription) {
        return InscriptionRepository.findById(numInscription).orElse(null);
    }

    @Override
    public List<Inscription> retrieveAllInscriptions() {
        return InscriptionRepository.findAll();
    }
    @Override
    public Inscription addRegistrationAndAssignToSkier(Inscription inscription, Long numSkieur) {
        Skieur sk = skieurRepository.findById(numSkieur).orElseThrow(() ->
                new NoSuchElementException("Skieur introuvable: " + numSkieur));
        inscription.setSkieur(sk);
        // si inscription a date/numSemaine etc -> ok
        return InscriptionRepository.save(inscription);
    }
    @Override
    public Inscription assignRegistrationToCourse(Long numInscription, Long numCourse)
    {
        Inscription ins = InscriptionRepository.findById(numInscription).orElseThrow(() ->
                new NoSuchElementException("Inscription introuvable: " + numInscription));
        Cours cours = coursRepository.findById(numCourse).orElseThrow(() ->
                new NoSuchElementException("Cours introuvable: " + numCourse));
        ins.setCours(cours);
        // si tu veux synchroniser les sets bidirectionnels :
        // cours.getInscriptions().add(ins);
        return InscriptionRepository.save(ins);
    }
    @Override
    public Inscription addRegistrationAndAssignToSkierAndCourse(Inscription inscription, Long numSkieur, Long numCours)
    {
        Skieur sk = skieurRepository.findById(numSkieur).orElseThrow(() ->
                new NoSuchElementException("Skieur introuvable: " + numSkieur));
        Cours cours = coursRepository.findById(numCours).orElseThrow(() ->
                new NoSuchElementException("Cours introuvable: " + numCours));
        inscription.setSkieur(sk);
        inscription.setCours(cours);
        return InscriptionRepository.save(inscription);
    }
}
