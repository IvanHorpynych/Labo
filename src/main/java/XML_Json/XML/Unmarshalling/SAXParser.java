package XML_Json.XML.Unmarshalling;

import XML_Json.XML.Marshalling.Person;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SAXParser implements IParser {

    @Override
    public  List<Person> unmarshalling(String filepath) throws ParserConfigurationException, IOException, SAXException {
        List<Person> persons = new ArrayList<>();
        SAXParserFactory factory = SAXParserFactory.newInstance();
        factory.setValidating(true);
        factory.setNamespaceAware(false);
        javax.xml.parsers.SAXParser parser = factory.newSAXParser();
        parser.parse(new File(filepath), new HandlerImpl(persons));
        return persons;
    }
}
