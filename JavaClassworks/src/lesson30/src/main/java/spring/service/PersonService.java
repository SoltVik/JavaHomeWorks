package spring.service;

import org.springframework.stereotype.Service;
import spring.domain.Person;
import spring.repository.PersonRepository;

import java.util.List;

@Service
public class PersonService {

    //@Autowired
    final private PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public void add(String firstName, String lastName) {
        Person person = new Person(firstName, lastName);
        personRepository.save(person);
    }

    public List<Person> findByFirstName(String firstName) {
        return personRepository.findByFirstName(firstName);
    }
}
