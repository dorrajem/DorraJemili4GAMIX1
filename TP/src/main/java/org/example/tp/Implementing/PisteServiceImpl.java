package org.example.tp.Implementing;
import org.example.tp.Entities.Piste;
import org.example.tp.Repositories.PisteRepository;
import org.example.tp.Services.IPisteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class PisteServiceImpl implements IPisteService {

    private static final Logger log = LoggerFactory.getLogger(PisteServiceImpl.class);

    public PisteServiceImpl(PisteRepository pisteRepository) {
        this.pisteRepository = pisteRepository;
    }

    private final PisteRepository pisteRepository;

    @Override
    public Piste addPiste(Piste piste) {
        log.info("Received Piste: {}", piste); // This will show nulls if not mapped
        return pisteRepository.save(piste);
    }

    @Override
    public Piste updatePiste(Piste piste) {
        return pisteRepository.save(piste);
    }

    @Override
    public Piste retrievePiste(Long numPiste) {
        return pisteRepository.findById(numPiste).orElse(null);
    }

    @Override
    public List<Piste> retrieveAllPistes() {
        return pisteRepository.findAll();
    }

    @Override
    public void removePiste(Long numPiste) {pisteRepository.deleteById(numPiste);}
}
