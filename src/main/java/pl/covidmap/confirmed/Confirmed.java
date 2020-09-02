package pl.covidmap.confirmed;

import pl.covidmap.countries.Countries;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Confirmed {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;

    private int value;

    @ManyToOne
    private Countries countries;

    public Confirmed() {
    }

    public Confirmed(LocalDate date, int value, Countries countries) {
        this.date = date;
        this.value = value;
        this.countries = countries;
    }
}
