package tn.esprit.dorrajemili4gamix1.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.dorrajemili4gamix1.Entity.Chambre;

@Repository
public interface ChambreRepository extends JpaRepository<Chambre, Long> {
}
