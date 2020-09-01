package pl.covidmap.calendar;

import pl.covidmap.dayResults.DayResults;

@Entity
public class Calendar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    @OneToMany(fetch = EAGER)
    private DayResults dayResults;
}
