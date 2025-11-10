package org.example.tp.Entities;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.example.tp.Enum.Couleur;

import java.util.Set;
@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

public class Piste {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long numPiste;
    String nomPiste;
    Couleur couleur;
    int longueur;
    int pente;
    @ManyToMany(mappedBy = "pistes")
    Set<Skieur> skieurs;
}
