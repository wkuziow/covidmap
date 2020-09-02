package pl.covidmap.confirmed;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfirmedRepository extends JpaRepository<Confirmed, Long> {
}
