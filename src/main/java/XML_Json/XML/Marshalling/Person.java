package XML_Json.XML.Marshalling;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "person")
@XmlAccessorType(XmlAccessType.FIELD)
public class Person implements Comparable {
    public static String TAG_ID = "id";
    public static String TAG_NAME = "name";
    public static String TAG_ADDRESS = "address";
    public static String TAG_CASH = "cash";
    public static String TAG_EDUCATION = "education";
    public static String TAG_PERSON = "person";

    @XmlAttribute
    int id;
    @XmlElement
    String name;
    @XmlElement
    String address;
    @XmlElement
    float cash;
    @XmlElement
    String education;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String adress) {
        this.address = adress;
    }

    public float getCash() {
        return cash;
    }

    public void setCash(float cash) {
        this.cash = cash;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    @Override
    public String toString() {
        return "person: " +
                "[ id=" + getId() +
                "; name=" + getName() +
                "; address=" + getAddress() +
                "; cash=" + getCash() +
                "; education=" + getEducation() + ";]";
    }

    @Override
    public int compareTo(Object o) {
        if (cash < ((Person) o).getCash())
            return -1;
        else if (cash > ((Person) o).getCash())
            return 1;
        else
            return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (id != ((Person) obj).getId()
                || !name.equals(((Person) obj).getName())
                || !address.equals(((Person) obj).getAddress())
                || cash != ((Person) obj).getCash()
                || !education.equals(((Person) obj).getEducation())) {
            return false;
        }
        return true;
    }
}
