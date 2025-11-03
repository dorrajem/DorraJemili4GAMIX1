package tn.esprit.dorrajemili4gamix1.Entity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)

public class Chambre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     Long idChambre;
     Long numeroChambre;
    @Enumerated(EnumType.STRING)
     TypeChambre typeC;

    @ManyToOne
     Bloc bloc;

    @OneToMany
     Set<Reservation> reservations;
}