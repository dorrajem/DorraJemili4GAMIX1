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

public class Moniteur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    LocalDate dateRecru;
    Long numMoniteur;
    String prenomM;
    String nomM;

    @OneToMany
    Set<Cours> cours;
}
