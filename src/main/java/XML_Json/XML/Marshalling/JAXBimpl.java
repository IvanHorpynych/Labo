package XML_Json.XML.Marshalling;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;

public class JAXBimpl {

    public static String FILEPATH = "./src/main/resources/output/";
    public static String FILENAME = "catalog.xml";
    private static Marshaller jaxbMarshaller;

    public static void marshal(String filepath, Catalog list) throws JAXBException {
        getMarshallerInstance().marshal(list, new File(filepath));
    }

    private static Marshaller getMarshallerInstance() throws JAXBException {

        JAXBContext jaxbContext = JAXBContext.newInstance(Catalog.class);
        jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        return jaxbMarshaller;

    }
}
