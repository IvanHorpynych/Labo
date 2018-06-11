import XML_Json.Json.RateParser;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

import static XML_Json.Json.FileWorker.fileReader;
import static XML_Json.Json.FileWorker.fileWriter;
import static XML_Json.Json.RateParser.getActualRates;
import static XML_Json.Json.RateParser.getRatesMap;

public class TestJson extends Assert {

    @Test
    public void testJsonParser(){
        assertNotNull(getActualRates());
        assertEquals("Rates list not have enough rates!",getActualRates().size(),60);
        assertEquals("Rates map not have enough rates!",getRatesMap().size(),60);
        assertEquals("Rates map not have enough specified rates!",getRatesMap("EUR","RUB","USD").size(),3);

        getRatesMap("EUR","RUB","USD").entrySet().stream().forEach(set->
               assertTrue(Arrays.asList("EUR","RUB","USD").contains(set.getKey())));
    }

    @Test
    public void testFileWorker(){

        Map<String,Double> rates = RateParser.getRatesMap();
        Map<String,Double> tempRates = null;
        try {
            fileWriter(rates);
            tempRates = fileReader();
        } catch (IOException e) {
            fail(e.getMessage());
        }

        assertTrue(rates.entrySet().containsAll(tempRates.entrySet()));
        assertTrue(tempRates.entrySet().containsAll(rates.entrySet()));

    }
}
