package XML_Json.XML.Marshalling;

import javax.xml.bind.JAXBException;
import java.util.ArrayList;

public class Main {
    public static String FILEPATH = "./src/main/resources/output/";
    public static String FILENAME = "catalog.xml";

    public static void main(String[] args) {
        Notebook notebook = new Notebook();
        Catalog catalog = new Catalog();

        notebook.setPersons(new ArrayList<>());
        catalog.setNotebooks(new ArrayList<>());

        Person person1 = new Person();
        person1.setId(1);
        person1.setAddress("address1");
        person1.setCash(10000);
        person1.setName("John");
        person1.setEducation("KPI");

        Person person2 = new Person();
        person2.setId(2);
        person2.setAddress("address2");
        person2.setCash(20000);
        person2.setName("Slava");
        person2.setEducation("NAU");

        Person person3 = new Person();
        person3.setId(3);
        person3.setAddress("address3");
        person3.setCash(300000);
        person3.setName("Vlad");
        person3.setEducation("Sheva");

        notebook.getPersons().add(person1);
        notebook.getPersons().add(person2);
        notebook.getPersons().add(person3);
        catalog.getNotebooks().add(notebook);

        try {
            JAXBimpl.marshal(FILEPATH+FILENAME, catalog);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
