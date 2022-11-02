package spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.domain.Person;
import spring.repository.PersonRepository;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public void add(String firstName, String lastName) {
        Person person = new Person(firstName, lastName);
        personRepository.save(person);
    }

    public List<Person> getAll() {
        return personRepository.findAll();
    }

    public void add(Person person) {
        personRepository.save(person);
    }

    public Person get (int id) {
        return personRepository.findById(id).get();
    }

    public void set (int id, Person person) {
        Person old = personRepository.findById(id).get();
        old.setFirstName(person.getFirstName());
        old.setLastName(person.getLastName());
        personRepository.save(old);
    }

    public void remove (int id) {
        Person person = personRepository.findById(id).get();
        personRepository.delete(person);
    }

//    public List<Person> findByFirstName(String firstName) {
//        return personRepository.findByFirstName(firstName);
//    }
}
