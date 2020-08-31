package pl.covidmap.Data;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Days {

    private LocalDate yesterday = LocalDate.now().minusDays(2);

    private LocalDate fiveDaysAgo = LocalDate.now().minusDays(6);

    private String fiveDaysAgoFormated = fiveDaysAgo.format(DateTimeFormatter.ofPattern("MM-dd-yyyy"));

    private String yesterdayFormated = yesterday.format(DateTimeFormatter.ofPattern("MM-dd-yyyy"));

    public LocalDate getYesterday() {
        return yesterday;
    }

    public LocalDate getFiveDaysAgo() {
        return fiveDaysAgo;
    }

    public String getFiveDaysAgoFormated() {
        return fiveDaysAgoFormated;
    }

    public String getYesterdayFormated() {
        return yesterdayFormated;
    }
}
