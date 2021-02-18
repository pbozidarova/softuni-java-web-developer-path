package course.springdata;

import course.springdata.model.Address;
import course.springdata.model.Person;
import course.springdata.model.PhoneNumber;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Address address1 = new Address(1L, "Bulgaria", "Sofia", "bul. Tsar Osvoboditel, 58");
        Person person1 = new Person(1L, "Petar",
                "Petrov", address1, Set.of(new PhoneNumber("+3598"), new PhoneNumber("+2599")));

        //1. Create JAXBContext
        try {
            JAXBContext ctx = JAXBContext.newInstance(Person.class);
            //2. Create Marshaller
            Marshaller marshaller = ctx.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            //3. Marshal POJO to XML
            marshaller.marshal(person1, new File("person.xml"));
//            marshaller.marshal(person1, System.out);


        } catch (JAXBException e) {
            e.printStackTrace();
        }


    }
}
