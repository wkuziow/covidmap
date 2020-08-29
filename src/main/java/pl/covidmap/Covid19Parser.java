package pl.covidmap;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.io.StringReader;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class Covid19Parser {

    private static final String url =
    "https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_covid19_confirmed_global.csv";

    public List<Point> getCovidData() throws IOException {
        List<Point> points = new ArrayList<>();
        RestTemplate restTemplate = new RestTemplate();
        String value = restTemplate.getForObject(url, String.class);

        StringReader stringReader = new StringReader(value);

        CSVParser parse = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(stringReader);


        LocalDate yesterday = LocalDate.now().minusDays(1);

        for (CSVRecord strings : parse) {
            double lat = Double.parseDouble(strings.get("Lat"));
            double lon = Double.parseDouble(strings.get("Long"));
            String text = strings.get(yesterday.format(DateTimeFormatter.ofPattern("M/dd/yy")));
            //String text = strings.get(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT).format(yesterday));

            points.add(new Point(lat, lon, text));
        }
        return points;
    }
}
