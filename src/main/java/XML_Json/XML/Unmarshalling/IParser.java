package XML_Json.XML.Unmarshalling;

import XML_Json.XML.Marshalling.Person;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public interface IParser {
    String FILEPATH = "./src/main/resources/output/";
    String FILENAME = "catalog.xml";
    String OUTPUT_FILENAME = "out.txt";
    //List<Person> persons = new ArrayList<>();

     List<Person> unmarshalling(String filepath) throws ParserConfigurationException, IOException, SAXException;
}
