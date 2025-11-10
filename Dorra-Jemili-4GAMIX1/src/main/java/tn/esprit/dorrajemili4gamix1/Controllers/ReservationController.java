package tn.esprit.dorrajemili4gamix1.Controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.dorrajemili4gamix1.Entity.Etudiant;
import tn.esprit.dorrajemili4gamix1.Entity.Reservation;
import tn.esprit.dorrajemili4gamix1.Services.IReservationService;

@RestController

public class ReservationController {
    public ReservationController(IReservationService reservationService) {
        this.reservationService = reservationService;
    }

    private final IReservationService reservationService;

    @PostMapping("/addReservation")
    public Reservation addReservation(@RequestBody Reservation reservation) {
        return reservationService.ajouterReservation(reservation);
    }

    @PutMapping("/updateReservation")
    public Reservation updateReservation(@RequestBody Reservation reservation) {
        return reservationService.modifierReservation(reservation);
    }

    @DeleteMapping("/deleteReservation/{id}")
    public void deleteReservation(@PathVariable("id") Long idReservation) {
        reservationService.supprimerReservation(idReservation);
    }

    @GetMapping("/getReservation/{id}")
    public Reservation getReservation(@PathVariable("id") Long idReservation) {
        return reservationService.getReservation(idReservation);
    }
}
