package spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.domain.Person;
import spring.service.PersonService;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("spring");
        context.refresh();

        PersonService personService = (PersonService) context.getBean("personService");
        //personService.add("Sidors", "Sidorovs");
        List<Person> persons = personService.findByFirstName("Ivan");
        System.out.println(persons);

        context.close();
    }
}
