package org.example.tp.Entities;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.example.tp.Enum.TypeAbonnement;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Abonnement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idAbonnement;
    TypeAbonnement typeAbon;
    LocalDate dateDebut;
    LocalDate dateFin;
    float prixAbon;

}
