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

public class Inscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long numInscription;
    int numSemaine;
    @ManyToOne
    Skieur skieur;

    @ManyToOne
    Cours cours;
}
