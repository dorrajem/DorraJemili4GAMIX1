package org.example.tp.Services;
import org.example.tp.Entities.Skieur;
import org.example.tp.Enum.TypeAbonnement;
import java.util.List;

public interface ISkieurService {
    List<Skieur> retrieveAllSkieurs();
    Skieur addSkieur(Skieur skieur);
    void removeSkieur (Long numSkieur);
    Skieur retrieveSkieur (Long numSkieur);
    Skieur assignSkieurToPiste(Long numSkieur, Long numPiste);
    Skieur addSkierAndAssignToCourse(Skieur skieur, Long numCourse);
    List<Skieur> retrieveSkiersBySubscriptionType(TypeAbonnement typeAbonnement);



}
