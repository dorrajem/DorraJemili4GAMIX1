package tn.esprit.dorrajemili4gamix1.Entity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.sql.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)

public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     Long idReservation;
     String numeroReservation;
     Date anneeUniversitaire;
     boolean estValide;

    @ManyToMany(mappedBy="reservations")
     Set<Etudiant> etudiant;
}