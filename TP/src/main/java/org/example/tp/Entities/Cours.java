package org.example.tp.Entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.example.tp.Enum.Support;
import org.example.tp.Enum.TypeCours;

import java.util.Set;
@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

public class Cours {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numCours;
    private int niveau;
    private TypeCours typeCours;
    private Support support;
    private float prix;
    private int crenaux;

    @OneToMany(mappedBy = "cours")
    private Set<Inscription> inscriptions;
    /*@ManyToOne
    private Moniteur moniteur;*/
}
