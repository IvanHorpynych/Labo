package XML_Json.XML.Unmarshalling;

import XML_Json.XML.Marshalling.Person;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.List;

public class HandlerImpl extends DefaultHandler {

    Person tempPerson;
    List<Person> persons;
    String thisElement = "";

    HandlerImpl(List<Person> persons){
        this.persons = persons;
    }
    @Override
    public void startDocument() throws SAXException {
        tempPerson = new Person();
    }

    @Override
    public void startElement(String namespaceURI, String localName, String qName, Attributes atts) throws SAXException {
        thisElement = qName;
        if(thisElement.equals(Person.TAG_PERSON))
            tempPerson.setId(Integer.valueOf(atts.getValue(0)));
    }

    @Override
    public void endElement(String namespaceURI, String localName, String qName) throws SAXException {
        if(thisElement.equals(Person.TAG_PERSON))
            persons.add(tempPerson);
        thisElement = "";
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {

        if (thisElement.equals(Person.TAG_NAME)) {
            tempPerson.setName(String.valueOf(ch, start, length));
        }
        if (thisElement.equals(Person.TAG_ADDRESS)) {
            tempPerson.setAddress(String.valueOf(ch, start, length));
        }
        if (thisElement.equals(Person.TAG_EDUCATION)) {
            tempPerson.setEducation(String.valueOf(ch, start, length));
        }
        if (thisElement.equals(Person.TAG_CASH)) {
            tempPerson.setCash(Float.valueOf(String.valueOf(ch, start, length)));
        }

    }

    @Override
    public void endDocument() {

    }

}
