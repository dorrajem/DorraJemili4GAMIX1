package tn.esprit.dorrajemili4gamix1.Implementing;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import tn.esprit.dorrajemili4gamix1.Entity.Bloc;
import tn.esprit.dorrajemili4gamix1.Repository.BlocRepository;
import tn.esprit.dorrajemili4gamix1.Services.IBlocService;

import java.util.List;


@Service
public class BlocServiceImpl implements IBlocService {


    private static final Logger log = LoggerFactory.getLogger(BlocServiceImpl.class);

    public BlocServiceImpl(BlocRepository blocRepository) {
        this.blocRepository = blocRepository;
    }

    private final BlocRepository blocRepository;

    @Override
    public Bloc ajouterBloc(Bloc bloc) {
        log.info("Received Bloc: {}", bloc); // This will show nulls if not mapped
        return blocRepository.save(bloc);
    }

    @Override
    public Bloc modifiererBloc(Bloc bloc) {
        return blocRepository.save(bloc);
    }

    @Override
    public void supprimerBloc(Long id) {
        blocRepository.deleteById(id);
    }

    @Override
    public Bloc getBloc(Long id) {
        return blocRepository.findById(id).orElse(null);
    }

    @Override
    public List<Bloc> getBlocs() {
        return blocRepository.findAll();
    }
}
