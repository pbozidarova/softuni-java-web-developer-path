package course.springdata;

import course.springdata.model.Address;
import course.springdata.model.Person;
import course.springdata.model.PhoneNumber;
import course.springdata.model.People;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Address address1 = new Address(1L, "Bulgaria", "Sofia", "bul. Tsar Osvoboditel, 58");
        Address address2 = new Address(2L, "Bulgaria", "Vidin", "bul. Hrsto Botev, 50");
        Address address3 = new Address(3L, "Bulgaria", "Tryavna", "bul. Ivan Vazov, 28");

        Person person1 = new Person(1L, "Petar",
                "Petrov", address1, Set.of(new PhoneNumber("+3598"), new PhoneNumber("+2599")));

        Person person2 = new Person(2L, "Georgie",
                "Hristov", address2, Set.of(new PhoneNumber("+3592"), new PhoneNumber("+2599")));

        Person person3 = new Person(3L, "Stamat",
                "Ivanov", address3, Set.of(new PhoneNumber("+3591"), new PhoneNumber("+2599")));

        List<Address> addresses = List.of(address1, address2, address3);
        List<Person> people = List.of(person1, person2, person3);

        //1. Create JAXBContext
        try {
            JAXBContext ctx = JAXBContext.newInstance(Person.class, People.class);
            //2. Create Marshaller
            Marshaller marshaller = ctx.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            //3. Marshal POJO to XML
            marshaller.marshal(person1, new File("person.xml"));
            marshaller.marshal(people.get(0), new File("people.xml"));
//            marshaller.marshal(person1, System.out);

            //4. Marshal multiple people to people.xml
            marshaller.marshal(new People(people), new File("people.xml"));
            StringWriter out = new StringWriter();
            marshaller.marshal(new People(people), out);

//            System.out.printf("StringWriter: %s%n", out.toString());

            //5. Unmarshal multiple Persons from XML to Java
            Unmarshaller unmarshaller = ctx.createUnmarshaller();
            People unmarshalledPeople =  (People) unmarshaller.unmarshal(new File("people.xml"));
            unmarshalledPeople.getPeople().forEach(p ->{
                System.out.printf("| %5d | %-10.10s | %-10.10s | %-40.40s | %-10.10s |%n",
                        p.getId(), p.getFirstName(), p.getLastName(),
                        p.getAddress().getCountry() + ", " + p.getAddress().getCity() + ", " + p.getAddress().getStreet(),
                        p.getPhoneNumbers()
                                .stream()
                                .map(PhoneNumber::getNumber)
                                .collect(Collectors.joining(", ")));
            });
        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }
}
