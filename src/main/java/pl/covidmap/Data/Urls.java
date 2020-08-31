package pl.covidmap.Data;

import org.springframework.stereotype.Service;

@Service
public class Urls {

    private static final String URL_BASIC =
            "https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_covid19_confirmed_global.csv";

private static final String URL_ADVANCED =
        "https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_daily_reports/";

    public static String getUrlAdvanced() {
        Days days = new Days();
        return URL_ADVANCED + days.getYesterdayFormated() + ".csv";
    }

    public String getURL_BASIC() {
        return URL_BASIC;
    }

}
