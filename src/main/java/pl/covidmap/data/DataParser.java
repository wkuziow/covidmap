package pl.covidmap.data;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;
import pl.covidmap.countries.Countries;
import pl.covidmap.countries.CountriesRepisotory;
import pl.covidmap.countries.CountriesUtils;
import pl.covidmap.point.Point;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DataParser {

    private GetData getData;

    private Urls urls;

    private CountriesRepisotory countriesRepisotory;

    private CountriesUtils countriesUtils;

    public DataParser(GetData getData, Urls urls, CountriesRepisotory countriesRepisotory, CountriesUtils countriesUtils) {
        this.getData = getData;
        this.urls = urls;
        this.countriesRepisotory = countriesRepisotory;
        this.countriesUtils = countriesUtils;
    }

    public List<Point> parser() throws IOException {

        List<Point> points = new ArrayList<>();

        StringReader stringReader = new StringReader(getData.getDataMethod(urls.getUrlAdvanced()));

        CSVParser parse = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(stringReader);

        for (CSVRecord strings : parse) {
            String latString = strings.get("Lat");
            String lonString = strings.get("Long_");
            String FIPS = strings.get("FIPS");
            if (!latString.isEmpty() && !lonString.isEmpty() && FIPS.isEmpty()) {
                double lat = Double.parseDouble(latString);
                double lon = Double.parseDouble(lonString);
                Days days = new Days();

                countriesUtils.saveCountry(lat, lon, strings);
                countriesUtils.saveConfirmed(strings, days.getYesterday());


                String text = strings.get("Combined_Key").replace("'", "") +
                        "<br>" +
                        "Last update: " + strings.get("Last_Update") +
                        "<br>" +
                        "Confirmed: " + strings.get("Confirmed") +
                        "<br>" +
                        "Deaths: " + strings.get("Deaths") +
                        "<br>" +
                        "Recovered: " + strings.get("Recovered") +
                        "<br>" +
                        "Active cases: " + strings.get("Active") +
                        "<br>" +
                        "New cases since last update: " +
                        "<br>" +
                        "Cases per 100,000 persons: " + strings.get("Incidence_Rate") +
                        "<br>" +
                        "Number recorded deaths / Number cases (%): " + strings.get("Case-Fatality_Ratio");

                points.add(new Point(lat, lon, text));
            }
        }

        return points;
    }
}
