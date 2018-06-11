package XML_Json.XML.Unmarshalling;

import XML_Json.XML.Marshalling.Person;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class XMLEngine {

 public static List<Person> parseXML(IParser parser) throws IOException,
         SAXException, ParserConfigurationException {
     return parser.unmarshalling(IParser.FILEPATH+IParser.FILENAME);
 }

 public static void fileWriter(String filename, List<Person> persons) throws IOException {
     FileWriter writer = new FileWriter(filename);

     for(Person person: persons){
         writer.write('\n');
         writer.write(person.toString());
     }

     writer.close();
 }

    public static void consoleWriter(List<Person> persons) throws IOException {

        for(Person person: persons){
            System.out.println(person.toString());
        }

    }

    public static List<Person> cashFilter(List<Person> persons, double cash){
       return persons.stream().filter((person) -> person.getCash() > cash).collect(Collectors.toList());
    }

    public static List<Person> cashFilter(List<Person> persons){
       return cashFilter(persons, 10000);
    }

}
