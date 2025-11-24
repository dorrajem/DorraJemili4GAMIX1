package org.example.tp.Services;
import org.example.tp.Entities.Inscription;

import java.util.List;

public interface IInscriptionService {
    List<Inscription> retrieveAllInscriptions();
    Inscription addInscription(Inscription inscription);
    void removeInscription (Long numInscription);
    Inscription retrieveInscription (Long numInscription);


}
