package org.example.tp.Services;
import org.example.tp.Entities.Abonnement;

import java.util.List;

public interface IAbonnementService {
    List<Abonnement> retrieveAllAbonnements();
    Abonnement addAbonnement(Abonnement abonnement);
    void removeAbonnement (Long numAbonnement);
    Abonnement retrieveAbonnement (Long numAbonnement);


}
