package spring.controller.vo;


import spring.domain.Person;

public class PersonVO {
    private int id;
    private String firstName;
    private String lastName;

    public PersonVO(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public static PersonVO valueOf(Person person) {
        return new PersonVO(person.getId(), person.getFirstName(), person.getLastName());
    }
}
