package spring.controller.vo;


import spring.domain.Person;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class PersonVO {
    private int id;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @NotNull
    @Min(18)
    @Max(60)
    private int age;

    public PersonVO(int id, String firstName, String lastName, int age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public static PersonVO valueOf(Person person) {
        return new PersonVO(person.getId(), person.getFirstName(), person.getLastName(), person.getAge());
    }
}
