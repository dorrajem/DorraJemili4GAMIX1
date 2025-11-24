package org.example.tp.Repositories;

import org.example.tp.Entities.Cours;
import org.example.tp.Entities.Inscription;
import org.example.tp.Entities.Skieur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InscriptionRepository extends JpaRepository<Inscription, Long> {
    List<Inscription> findBySkieur(Skieur skieur);
    List<Inscription> findByCours(Cours cours);
}
