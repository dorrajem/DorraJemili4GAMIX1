package org.example.tp.Implementing;

import org.example.tp.Entities.Abonnement;
import org.example.tp.Repositories.AbonnementRepository;
import org.example.tp.Services.IAbonnementService;
import org.example.tp.Enum.TypeAbonnement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class AbonnementServiceImpl implements IAbonnementService {

    private static final Logger log = LoggerFactory.getLogger(AbonnementServiceImpl.class);

    public AbonnementServiceImpl(AbonnementRepository AbonnementRepository) {
        this.AbonnementRepository = AbonnementRepository;
    }

    private final AbonnementRepository AbonnementRepository;

    @Override
    public Abonnement addAbonnement(Abonnement Abonnement) {
        log.info("Received Abonnement: {}", Abonnement); // This will show nulls if not mapped
        return AbonnementRepository.save(Abonnement);
    }

    @Override
    public void removeAbonnement (Long numAbonnement) {
         AbonnementRepository.deleteById(numAbonnement);
    }

    @Override
    public Abonnement retrieveAbonnement(Long numAbonnement) {
        return AbonnementRepository.findById(numAbonnement).orElse(null);
    }

    @Override
    public List<Abonnement> retrieveAllAbonnements() {
        return AbonnementRepository.findAll();
    }

    @Override
    public Set<Abonnement> getSubscriptionByType(TypeAbonnement type) {
        List<Abonnement> list = AbonnementRepository.findByTypeAbon(type);
        return new HashSet<>(list);
    }

    @Override
    public List<Abonnement> retrieveSubscriptionsByDates(LocalDate startDate, LocalDate endDate) {
        return AbonnementRepository.findByDateDebutBetween(startDate, endDate);
    }
}
