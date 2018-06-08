package XML_Json.XML.Marshalling;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "notebook")
@XmlAccessorType(XmlAccessType.FIELD)
public class Notebook {

    @XmlElement(name = "person")
    private List<Person> persons = null;

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }
}
