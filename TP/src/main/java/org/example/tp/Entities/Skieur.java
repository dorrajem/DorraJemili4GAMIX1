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
    String nomS;
    String prenomS;
    String dateNaissance;
    String ville;

    @OneToOne(cascade = CascadeType.ALL)
    Abonnement abonnement;
    @OneToMany(mappedBy = "skieur")
    Set<Inscription> inscriptions;
    @ManyToMany
    Set<Piste> pistes;
}
