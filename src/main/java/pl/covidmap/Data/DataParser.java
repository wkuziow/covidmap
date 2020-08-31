package pl.covidmap.Data;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;
import pl.covidmap.Point.Point;

import java.io.IOException;
import java.io.StringReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class DataParser {

    private GetData getData;

    private Urls urls;

    public DataParser(GetData getData, Urls urls) {
        this.getData = getData;
        this.urls = urls;
    }

    public List<Point> parser() throws IOException {

        List<Point> points = new ArrayList<>();

//        StringReader stringReader = new StringReader(getData.getDataMethod(urls.getURL_BASIC()));
        StringReader stringReader = new StringReader(getData.getDataMethod(urls.getUrlAdvanced()));

        CSVParser parse = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(stringReader);

        for (CSVRecord strings : parse) {
                String latString = strings.get("Lat");
                String lonString = strings.get("Long_");
                String FIPS = strings.get("FIPS");
                if (!latString.isEmpty() && !lonString.isEmpty() && FIPS.isEmpty()) {
                double lat = Double.parseDouble(latString);
                double lon = Double.parseDouble(lonString);

//            String text = strings.get(days.getYesterday().format(DateTimeFormatter.ofPattern("M/dd/yy")));
                String text = strings.get("Country_Region").replace("'", "") + "<br>" + "Confirmed: " + strings.get("Confirmed");

                points.add(new Point(lat, lon, text));
            }
        }

        return points;
    }
}
