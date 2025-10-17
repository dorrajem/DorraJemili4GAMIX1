package tn.esprit.dorrajemili4gamix1.Entity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.sql.Date;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)

public class Etudiant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     Long idEtudiant;
     String nomEt;
     String prenomEt;
     String cin;
     String ecole;
     Date dateNaissance;

    @ManyToMany
     Set<Reservation> reservations;
}