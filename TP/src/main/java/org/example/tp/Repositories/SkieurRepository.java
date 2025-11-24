package org.example.tp.Repositories;

import org.example.tp.Entities.Abonnement;
import org.example.tp.Entities.Skieur;
import org.example.tp.Enum.TypeAbonnement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SkieurRepository extends JpaRepository<Skieur, Long> {
    List<Skieur> findByAbonnementTypeAbon(TypeAbonnement typeAbon);

    Skieur findByAbonnement(Abonnement abonnement);
}
