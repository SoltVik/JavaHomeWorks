/**
 * Java. Homework #12 part 2
 *
 * @author Viktors Soltums
 * @version 31 Jul 2022
 */
/*
Написать простой класс Телефонный Справочник, который хранит в себе список фамилий и телефонных номеров.
 В этот телефонный справочник с помощью метода add() можно добавлять записи,
  а с помощью метода get() искать номер телефона по фамилии.
Следует учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев), тогда при запросе такой фамилии должны выводиться все телефоны.

Желательно не добавлять лишний функционал (дополнительные поля (имя, отчество, адрес), взаимодействие с пользователем через консоль и т.д). Консоль использовать только для вывода результатов проверки телефонного справочника.

 */
public class TestPhonebook {
    public static void main(String[] args) {
        Phonebook phonebook = new Phonebook();
        phonebook.init();

        System.out.println(phonebook);

        phonebook.add("Joy", "12301");
        phonebook.add("Joy", "12301");
        phonebook.add("Joy", "12301");
        System.out.println(phonebook);
        System.out.println("Joy: " + phonebook.get("Joy"));
    }
}
