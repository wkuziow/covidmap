package pl.covidmap.map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.covidmap.data.Covid19Parser;

import java.io.IOException;

@Controller
public class MapController {

    private Covid19Parser covid19Parser;

    public MapController(Covid19Parser covid19Parser) {
        this.covid19Parser = covid19Parser;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getMap(Model model) throws IOException {
        model.addAttribute("points", covid19Parser.getCovidData());
        return "map";
    }
}
