import XML_Json.XML.Marshalling.Catalog;
import XML_Json.XML.Marshalling.JAXBimpl;
import XML_Json.XML.Marshalling.Notebook;
import XML_Json.XML.Marshalling.Person;
import XML_Json.XML.Unmarshalling.DOMParser;
import XML_Json.XML.Unmarshalling.SAXParser;
import XML_Json.XML.Unmarshalling.XMLEngine;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static XML_Json.XML.Marshalling.JAXBimpl.FILENAME;
import static XML_Json.XML.Marshalling.JAXBimpl.FILEPATH;

public class TestXML extends Assert {

    private static Catalog catalog;

    @BeforeClass
    public static void createDefaultCatalog(){
        Notebook notebook = new Notebook();
        catalog = new Catalog();

        notebook.setPersons(new ArrayList<>());
        catalog.setNotebooks(new ArrayList<>());

        Person person1 = new Person();
        person1.setId(1);
        person1.setAddress("address1");
        person1.setCash(5000);
        person1.setName("John");
        person1.setEducation("KPI");

        Person person2 = new Person();
        person2.setId(2);
        person2.setAddress("address2");
        person2.setCash(8000);
        person2.setName("Slava");
        person2.setEducation("NAU");

        Person person3 = new Person();
        person3.setId(3);
        person3.setAddress("address3");
        person3.setCash(10001);
        person3.setName("Vlad");
        person3.setEducation("Sheva");

        notebook.getPersons().add(person1);
        notebook.getPersons().add(person2);
        notebook.getPersons().add(person3);
        catalog.getNotebooks().add(notebook);
    }

    @BeforeClass
    public static void testMarshalingData(){
        try {
            JAXBimpl.marshal(FILEPATH+FILENAME, catalog);
        } catch (JAXBException e) {
            fail("Not successful marshaling!\n"+e.getMessage());
        }
    }

    @Test
    public void testUnmarshallingDOMParser(){
        try {
            List<Person> resultList =  XMLEngine.parseXML(new DOMParser());

            assertTrue(equalLists(
                    resultList,catalog.getNotebooks().get(0).getPersons()));

        } catch (ParserConfigurationException | IOException | SAXException e) {
            fail(e.getMessage());
        }
    }


    @Test
    public void testUnmarshallingSAXParser(){
        try {
            List<Person> resultList =  XMLEngine.parseXML(new SAXParser());

            assertTrue(equalLists(
                    resultList,catalog.getNotebooks().get(0).getPersons()));

        } catch (ParserConfigurationException | IOException | SAXException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void cashFilterTest(){
        try {
            List<Person> resultList =  XMLEngine.parseXML(new SAXParser());

             resultList =  XMLEngine.cashFilter(resultList);

             assertEquals(resultList.size(), 1);

        } catch (ParserConfigurationException | IOException | SAXException e) {
            fail(e.getMessage());
        }
    }


    @SuppressWarnings("unchecked")
    private boolean equalLists(List<Person> first, List<Person> second){
        if (first == null && second == null){
            return true;
        }

        if((first == null || second == null)
                || first.size() != second.size()){
            return false;
        }

        first = new ArrayList<>(first);
        second = new ArrayList<>(second);

        Collections.sort(first);
        Collections.sort(second);

        return first.equals(second);
    }

}
