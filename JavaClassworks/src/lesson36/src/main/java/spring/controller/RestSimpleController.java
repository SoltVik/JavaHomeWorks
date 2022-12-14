package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.controller.vo.PersonVO;
import spring.domain.Person;
import spring.service.PersonService;
import spring.util.StringUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class RestSimpleController implements SimpleRestApi {

    @Autowired
    PersonService personService;


    @Override
    public ResponseEntity<PersonVO> add(PersonVO body) {
        String firstName = body.getFirstName();
        String lastName = body.getLastName();

        Person newPerson = null;
        if (!StringUtil.isEmpty(firstName) && !StringUtil.isEmpty(lastName)) {
            newPerson = new Person(firstName, lastName);
            personService.add(newPerson);
        }
        return ResponseEntity.ok(PersonVO.valueOf(newPerson));
    }

    @Override
    public ResponseEntity<Void> delete(Integer id) {
        if (personService.remove(id)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<PersonVO> get(Integer id) {
        Person person = personService.findById(id);
        if (person != null) {
            return ResponseEntity.ok(PersonVO.valueOf(person));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<List<PersonVO>> getAll() {
        List<Person> persons = personService.findAll();
        List<PersonVO> personVO = persons.stream()
                .map(e -> PersonVO.valueOf(e))
                .collect(Collectors.toList());

        return ResponseEntity.ok(personVO);
    }

    @Override
    public ResponseEntity<PersonVO> update(Integer id, PersonVO body) {
        Person person = personService.update(id, body);
        return ResponseEntity.ok(PersonVO.valueOf(person));
    }
}