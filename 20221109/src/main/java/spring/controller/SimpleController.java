package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import spring.domen.Person;
import spring.service.PersonService;

@Controller
public class SimpleController {

    @Autowired
    PersonService personService;

    @GetMapping("/")
    public String index(Model model) {
        return "index";
    }

    @GetMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("name", "Spring!");
        return "hello";
    }

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("persons", personService.getAll());
        return "list";
    }

    @GetMapping(value = "/add")
    public String showAddPersonForm(Model model) {
        Person person = new Person();
        model.addAttribute("person", person);
        return "add";
    }

    @PostMapping(value = "/add")
    public String addPerson(Model model, @ModelAttribute("person") Person person) {

        String firstName = person.getFirstName();
        String lastName = person.getLastName();

        if (firstName != null && firstName.length() > 0 && lastName != null && lastName.length() > 0) {
            Person newPerson = new Person(firstName, lastName);
            personService.add(newPerson);

            return "redirect:/list";
        }
        model.addAttribute("errorMessage", "First Name & Last Name is required!");
        return "add";
    }

    @DeleteMapping(value = "/delete")
    public String deletePerson(int id) {
        personService.remove(id);
        return "redirect:/list";
    }

    @GetMapping("/update/{id}")
    public String updatePersonForm(Model model, @PathVariable final Integer id) {
        model.addAttribute("persons", personService.getAll());
        Person person = personService.get(id);
        model.addAttribute("person", person);
        return "update";
    }

    @PostMapping(value = "/update/{id}")
    public String updatePerson(Model model, @ModelAttribute("person") Person person, @PathVariable Integer id) {

        String firstName = person.getFirstName();
        String lastName = person.getLastName();

        if (firstName != null && firstName.length() > 0 && lastName != null && lastName.length() > 0) {
            personService.set(id, person);

            return "redirect:/list";
        }

        model.addAttribute("errorMessage", "First Name & Last Name is required!");
        return "update";
    }
}