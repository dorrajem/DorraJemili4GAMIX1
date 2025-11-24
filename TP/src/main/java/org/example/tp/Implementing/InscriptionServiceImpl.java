package org.example.tp.Implementing;

import org.example.tp.Entities.Inscription;
import org.example.tp.Repositories.InscriptionRepository;
import org.example.tp.Services.IInscriptionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InscriptionServiceImpl implements IInscriptionService {

    private static final Logger log = LoggerFactory.getLogger(InscriptionServiceImpl.class);

    public InscriptionServiceImpl(InscriptionRepository InscriptionRepository) {
        this.InscriptionRepository = InscriptionRepository;
    }

    private final InscriptionRepository InscriptionRepository;

    @Override
    public Inscription addInscription(Inscription Inscription) {
        log.info("Received Inscription: {}", Inscription); // This will show nulls if not mapped
        return InscriptionRepository.save(Inscription);
    }

    @Override
    public void removeInscription (Long numInscription) {
         InscriptionRepository.deleteById(numInscription);
    }

    @Override
    public Inscription retrieveInscription(Long numInscription) {
        return InscriptionRepository.findById(numInscription).orElse(null);
    }

    @Override
    public List<Inscription> retrieveAllInscriptions() {
        return InscriptionRepository.findAll();
    }
}
