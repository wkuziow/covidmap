package pl.covidmap.countries;

import pl.covidmap.confirmed.Confirmed;

import javax.persistence.*;

@Entity
public class Countries {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String combinedKey; //name of the country

    private double lat;

    private double lon;


    public Countries() {
    }

    public Countries(String combinedKey, double lat, double lon) {
        this.combinedKey = combinedKey;
        this.lat = lat;
        this.lon = lon;
    }


}
