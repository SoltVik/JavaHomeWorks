package spring;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import spring.domain.Person;
import spring.service.PersonService;

import java.util.List;

@SpringBootTest
public class PersonServiceTest {

    @Autowired
    PersonService service;

    @Test
    public void testAdd() {
        List<Person> persons = service.getAll();
        int count = persons.size();

        Person p = new Person("Ivan", "Ivanov");
        service.add(p);
        persons = service.getAll();

        Assertions.assertEquals(count + 1 , persons.size());
        Assertions.assertEquals("Ivan", persons.get(0).getFirstName());
        Assertions.assertEquals("Ivanov", persons.get(0).getLastName());
    }

    @Test
    public void testRemove() {
        List<Person> persons = service.getAll();
        int count = persons.size();
        Person p = new Person("Petr", "Petrov");
        service.add(p);
        persons = service.getAll();
        Assertions.assertEquals(count + 1, persons.size());

        service.remove(p.getId());
        persons = service.getAll();
        Assertions.assertEquals(count, persons.size());
    }

    @Test
    public void testfindByFirstName() {
        Person p = new Person("Sidor", "Sidorov");
        service.add(p);

        List<Person> persons = service.findByFirstName("Sidor");
        Assertions.assertEquals(1 , persons.size());
        Assertions.assertEquals("Sidor", persons.get(0).getFirstName());
    }
}
