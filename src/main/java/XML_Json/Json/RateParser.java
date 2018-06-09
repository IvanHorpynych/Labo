package XML_Json.Json;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RateParser {

    private static URL currRatesUrl;

    static {
        try {
            currRatesUrl = new URL("https://bank.gov.ua/" +
                    "NBUStatService/v1/statdirectory/exchange?json");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public static List<Rate> getActualRates() {
        List<Rate> rates = new ArrayList<>();

        ObjectMapper mapper = new ObjectMapper();
        try {
            rates = mapper.readValue(currRatesUrl, new TypeReference<List<Rate>>() {});
        } catch (IOException e) {
            e.printStackTrace();
        }

        return rates;
    }

    public static Map<String, Double> getRatesMap(){
        return getActualRates().stream().collect(
                Collectors.toMap(Rate::getCc, Rate::getRate));
    }

    public static Map<String, Double> getSpecifiedRatesMap(String...options){
        return getRatesMap().entrySet().stream().filter(set->
                Arrays.asList(options).contains(set.getKey()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public static void main(String[] args) {
        System.out.println(getActualRates());
        System.out.println(getRatesMap());
        System.out.println(getSpecifiedRatesMap("EUR","RUB","USD"));
    }
}
