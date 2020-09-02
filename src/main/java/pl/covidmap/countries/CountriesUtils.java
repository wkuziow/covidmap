package pl.covidmap.countries;

import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;
import pl.covidmap.confirmed.Confirmed;
import pl.covidmap.confirmed.ConfirmedRepository;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class CountriesUtils {

    private CountriesRepisotory countriesRepisotory;

    private ConfirmedRepository confirmedRepository;

    public CountriesUtils(CountriesRepisotory countriesRepisotory, ConfirmedRepository confirmedRepository) {
        this.countriesRepisotory = countriesRepisotory;
        this.confirmedRepository = confirmedRepository;
    }

    public void saveCountry(double lat, double lon, CSVRecord strings){
        Optional<Countries> countriesOptional = countriesRepisotory.findCountriesByCombinedKey(strings.get("Combined_Key").replace("'", ""));

        if (!countriesOptional.isPresent()) {
            String combinedKey = strings.get("Combined_Key").replace("'", "");
            countriesRepisotory.save(new Countries(combinedKey, lat, lon));
        }
    }

    public void saveConfirmed(CSVRecord strings, LocalDate date) {
        String combinedKey = strings.get("Combined_Key").replace("'", "");
        Countries countries = countriesRepisotory.findCountriesByCombinedKey(combinedKey).get();
        int value = Integer.parseInt(strings.get("Confirmed"));
        confirmedRepository.save(new Confirmed(date, value, countries));
    }

}
