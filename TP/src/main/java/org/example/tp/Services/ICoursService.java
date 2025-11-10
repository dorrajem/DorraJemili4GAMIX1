package org.example.tp.Services;
import org.example.tp.Entities.Cours;

import java.util.List;

public interface ICoursService {
    List<Cours> retrieveAllCourses();
    Cours addCours(Cours cours);
    Cours updateCours (Cours cours);
    Cours retrieveCours (Long numCours);
}
