package tn.esprit.dorrajemili4gamix1.Entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)

public class Universite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     Long idUniversite;
     String nomUniversite;
     String adresse;
    @OneToOne(mappedBy = "universite")
     Foyer foyer;
}