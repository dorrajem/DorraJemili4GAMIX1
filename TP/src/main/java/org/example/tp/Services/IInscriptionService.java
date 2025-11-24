package org.example.tp.Services;
import org.example.tp.Entities.Inscription;

import java.util.List;

public interface IInscriptionService {
    List<Inscription> retrieveAllInscriptions();
    Inscription addInscription(Inscription inscription);
    void removeInscription (Long numInscription);
    Inscription retrieveInscription (Long numInscription);
    Inscription addRegistrationAndAssignToSkier(Inscription inscription, Long numSkieur);
    Inscription assignRegistrationToCourse(Long numInscription, Long numCourse);
    Inscription addRegistrationAndAssignToSkierAndCourse(Inscription inscription, Long numSkieur, Long numCours);

}
