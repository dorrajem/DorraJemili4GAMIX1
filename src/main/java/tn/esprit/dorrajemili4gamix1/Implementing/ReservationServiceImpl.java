package tn.esprit.dorrajemili4gamix1.Implementing;

import org.springframework.stereotype.Service;
import tn.esprit.dorrajemili4gamix1.Entity.Reservation;
import tn.esprit.dorrajemili4gamix1.Repository.ReservationRepository;
import tn.esprit.dorrajemili4gamix1.Services.IReservationService;
import java.util.List;


@Service
public class ReservationServiceImpl implements IReservationService {
    public ReservationServiceImpl(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    private final ReservationRepository reservationRepository;
    @Override
    public Reservation ajouterReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public Reservation modifierReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public void supprimerReservation(Long id) {
        reservationRepository.deleteById(id);
    }

    @Override
    public Reservation getReservation(Long id) {
        return reservationRepository.findById(id).orElse(null)  ;
    }

    @Override
    public List<Reservation> getReservations() {
        return reservationRepository.findAll();
    }
}
