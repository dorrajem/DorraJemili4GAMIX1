package org.example.tp.Entities;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.Set;
@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

public class Skieur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long numSkieur;
    Long nomS;
    Long prenomS;
    String dateNaissance;
    String ville;

    @OneToOne
    Abonnement abonnement;
    @OneToMany(mappedBy = "skieur")
    Set<Inscription> inscriptions;
    @ManyToMany
    Set<Piste> pistes;
}
