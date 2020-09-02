package pl.covidmap.countries;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CountriesRepisotory extends JpaRepository<Countries, Long> {

    Optional<Countries> findCountriesByCombinedKey (String combinedKey);


}
