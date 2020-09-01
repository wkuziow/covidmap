package pl.covidmap.data;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Service
public class GetData {

    public static String  getDataMethod(String url){
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url, String.class);

    }
}
