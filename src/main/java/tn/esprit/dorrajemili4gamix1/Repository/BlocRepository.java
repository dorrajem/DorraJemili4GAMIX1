package tn.esprit.dorrajemili4gamix1.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.dorrajemili4gamix1.Entity.Bloc;

@Repository
public interface BlocRepository extends JpaRepository<Bloc,Long> {
}
