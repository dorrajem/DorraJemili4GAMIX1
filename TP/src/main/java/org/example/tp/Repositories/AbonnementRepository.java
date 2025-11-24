package org.example.tp.Repositories;

import org.example.tp.Entities.Abonnement;
import org.example.tp.Enum.TypeAbonnement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface AbonnementRepository extends JpaRepository<Abonnement, Long> {
    List<Abonnement> findByTypeAbon(TypeAbonnement type);
    List<Abonnement> findByDateDebutBetween(LocalDate start, LocalDate end);
    List<Abonnement> findByDateFinBetween(LocalDate start, LocalDate end);
    List<Abonnement> findByDateFinAfter(LocalDate date);

}
