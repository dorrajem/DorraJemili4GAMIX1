package tn.esprit.dorrajemili4gamix1.Services;
import tn.esprit.dorrajemili4gamix1.Entity.Bloc;

import java.util.List;

public interface IBlocService {
    Bloc ajouterBloc(Bloc bloc);
    Bloc modifiererBloc(Bloc bloc);
    void supprimerBloc(Long id);
    Bloc getBloc(Long id);
    List<Bloc> getBlocs();

}
