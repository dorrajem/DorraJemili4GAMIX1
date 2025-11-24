package org.example.tp.Implementing;

import org.example.tp.Entities.Abonnement;
import org.example.tp.Entities.Skieur;
import org.example.tp.Repositories.AbonnementRepository;
import org.example.tp.Repositories.SkieurRepository;
import org.example.tp.Services.IAbonnementService;
import org.example.tp.Enum.TypeAbonnement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class AbonnementServiceImpl implements IAbonnementService {

    private static final Logger log = LoggerFactory.getLogger(AbonnementServiceImpl.class);
    private final SkieurRepository skieurRepository;

    public AbonnementServiceImpl(AbonnementRepository AbonnementRepository, SkieurRepository skieurRepository) {
        this.AbonnementRepository = AbonnementRepository;
        this.skieurRepository = skieurRepository;
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


    @Scheduled(cron= "0 0 0 * * *")
    public void retrieveSubscriptions()
    {
        LocalDate today = LocalDate.now();
        LocalDate sevenDaysLater = today.plusDays(7);

        List<Abonnement> abonnements = AbonnementRepository.findByDateFinBetween(today, sevenDaysLater);
        for(Abonnement abonnement : abonnements)
        {
            Skieur skieur= skieurRepository.findByAbonnement(abonnement);
            System.out.println(skieur.getNomS());
        }
    }

    @Scheduled(cron = "0 0 10 1 * ?")
    public void showMonthlyRecurringRevenue() {
        List<Abonnement> abonnementsActifs = AbonnementRepository.findByDateFinAfter(LocalDate.now());

        double mrr = abonnementsActifs.stream()
                .mapToDouble(ab -> {
                    switch (ab.getTypeAbon()) {
                        case MENSUEL:
                            return ab.getPrixAbon();
                        case SEMESTRIEL:
                            return ab.getPrixAbon() / 6.0;
                        case ANNUEL:
                            return ab.getPrixAbon() / 12.0;
                        default:
                            return 0;
                    }
                })
                .sum();

        System.out.println("Monthly Recurring Revenue (MRR) : " + mrr + " €");
    }
}
