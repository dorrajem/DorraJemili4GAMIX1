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
public class Bloc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     Long idBloc;
     String nomBloc;
     Long capaciteBloc;

    @ManyToOne
     Foyer foyer;

    @OneToMany(mappedBy = "bloc")
     Set<Chambre> chambres;
}