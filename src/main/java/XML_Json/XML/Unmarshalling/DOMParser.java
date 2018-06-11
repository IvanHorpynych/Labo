package XML_Json.XML.Unmarshalling;

import XML_Json.XML.Marshalling.Person;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DOMParser implements IParser {

     Person tempPerson;

    @Override
    public List<Person> unmarshalling(String filepath) throws ParserConfigurationException, IOException, SAXException {
        File xmlFile = new File(filepath);
        List<Person> persons = new ArrayList<>();
        DocumentBuilderFactory documentBuilderFactory =
                DocumentBuilderFactory.newInstance();


        Document document = documentBuilderFactory
                .newDocumentBuilder()
                .parse(xmlFile);

        NodeList nodeList = document.getElementsByTagName("person");

        for (int temp = 0; temp < nodeList.getLength(); temp++) {
            tempPerson = null;
            Node nNode = nodeList.item(temp);

            if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                Element eElement = (Element) nNode;

                tempPerson = new Person();
                tempPerson.setId(Integer.valueOf(eElement.getAttribute(Person.TAG_ID)));
                tempPerson.setName(eElement.getElementsByTagName(Person.TAG_NAME)
                        .item(0).getTextContent());
                tempPerson.setAddress(eElement.getElementsByTagName(Person.TAG_ADDRESS)
                        .item(0).getTextContent());
                tempPerson.setEducation(eElement.getElementsByTagName(Person.TAG_EDUCATION)
                        .item(0).getTextContent());
                tempPerson.setCash(Float.valueOf(eElement.getElementsByTagName(Person.TAG_CASH)
                        .item(0).getTextContent()));

                persons.add(tempPerson);
            }
        }
        return persons;
    }
}