package spring.controller;

import domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import spring.service.TestService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SimpleController {

    @Autowired
    TestService service;

    private static List<Person> persons = new ArrayList<>();

    static {
        persons.add(new Person("Bill", "Gates"));
        persons.add(new Person("Steve", "Jobs"));
    }

    @GetMapping("/")
    public String index(Model model) {
        return "index";
    }

    @GetMapping("/hello")
    public String hello(Model model) {
        service.test();
        model.addAttribute("name", "Spring!");
        return "hello";
    }

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("persons", persons);
        return "list";
    }

    @GetMapping("/add")
    public String showAddPersonForm(Model model) {
        Person person = new Person();
        model.addAttribute("person", person);
        return "add";
    }

    @RequestMapping(value = { "/add" }, method = RequestMethod.POST)
    public String addPerson(Model model, @ModelAttribute("person") Person person) {

        String firstName = person.getFirstName();
        String lastName = person.getLastName();

        if (firstName != null && firstName.length() > 0 && lastName != null && lastName.length() > 0) {
            persons.add(person);

            return "redirect:/list";
        }

        model.addAttribute("errorMessage", "First Name & Last Name is required!");
        return "add";
    }

    @GetMapping("/update")
    public String updateRedirect() {
        return "redirect:/list";
    }
    @GetMapping("/update/{id}")
    public String updatePersonForm(Model model, @PathVariable Integer id) {
        model.addAttribute("persons", persons);
        Person person = persons.get(id);
        model.addAttribute("person", person);
        return "update";
    }

    @RequestMapping(value = { "/update/{id}" }, method = RequestMethod.POST)
    public String updatePerson(Model model, @ModelAttribute("person") Person person, @PathVariable Integer id) {

        String firstName = person.getFirstName();
        String lastName = person.getLastName();

        if (firstName != null && firstName.length() > 0 && lastName != null && lastName.length() > 0) {
            persons.set(id, person);

            return "redirect:/list";
        }

        model.addAttribute("errorMessage", "First Name & Last Name is required!");
        return "update";
    }

   /* @RequestMapping("/delete")
    public String deletePerson(int id){
        persons.remove(id);
        return "redirect:/list";
    }*/

    @PostMapping(value = {"/delete"})

    public String deletePerson(int id) {

        persons.remove(id);
        return "redirect:/list";
    }
}
