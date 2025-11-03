package tn.esprit.dorrajemili4gamix1.Services;

import tn.esprit.dorrajemili4gamix1.Entity.Reservation;

import java.util.List;

public interface IReservationService {
    Reservation ajouterReservation(Reservation reservation);
    Reservation modifierReservation(Reservation reservation);
    void supprimerReservation(Long id);
    Reservation getReservation(Long id);
    List<Reservation> getReservations();
}
