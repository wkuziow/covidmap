package pl.covidmap.data;

import org.springframework.stereotype.Service;
import pl.covidmap.point.Point;

import java.io.IOException;
import java.util.List;

@Service
public class Covid19Parser {

private DataParser dataParser;

    public Covid19Parser(DataParser dataParser) {
        this.dataParser = dataParser;
    }

    public List<Point> getCovidData() throws IOException {
//        List<Point> points = new ArrayList<>();
////        RestTemplate restTemplate = new RestTemplate();
////        String value = restTemplate.getForObject(URL_BASIC, String.class);
//
//        StringReader stringReader = new StringReader(value);
//
//        CSVParser parse = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(stringReader);
//
//
//        LocalDate yesterday = LocalDate.now().minusDays(2);
//
//        for (CSVRecord strings : parse) {
//            double lat = Double.parseDouble(strings.get("Lat"));
//            double lon = Double.parseDouble(strings.get("Long"));
//            String text = strings.get(yesterday.format(DateTimeFormatter.ofPattern("M/dd/yy")));
//            //String text = strings.get(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT).format(yesterday));
//
//            points.add(new Point(lat, lon, text));
//        }
        return dataParser.parser();
    }
}
