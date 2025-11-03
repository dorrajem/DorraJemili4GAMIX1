package tn.esprit.dorrajemili4gamix1.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.dorrajemili4gamix1.Entity.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
