package org.example.tp.Repositories;

import org.example.tp.Entities.Cours;
import org.example.tp.Entities.Moniteur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CoursRepository extends JpaRepository<Cours, Long> {
    List<Cours> findByMoniteur(Moniteur moniteur);
}
