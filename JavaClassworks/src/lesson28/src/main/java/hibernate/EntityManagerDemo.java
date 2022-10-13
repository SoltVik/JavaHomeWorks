package hibernate;

import hibernate.domain.Person;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class EntityManagerDemo {
    public static void main(String[] args) {
        // Получаем фабрику менеджеров сущностей
        EntityManagerFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
        // Из фабрики создаем EntityManager
        EntityManager em = factory.createEntityManager();

        //add(em, "firstName", "lastName");

        Person person = em.find(Person.class, 1);
        System.out.println(person);

        person.setLastName("Petrov");
        update(em, person);

        //add(em, "Sidor", "Sidorov");
        person = em.find(Person.class, 3);
        System.out.println(person);
        remove(em, person);

    }

    static void add(EntityManager em, String firstName, String lastName){
        //Добавление записи
        Person person = new Person(firstName, lastName);

        // Открываем транзакцию
        em.getTransaction().begin();
        // Create (сохраняем в базе данных, и благодаря этому сущность
        // становится управляемой Hibernate и заносится в контекст постоянства)
        em.persist(person);
        // Подтверждаем транзакцию
        em.getTransaction().commit();
    }

    static Person find(EntityManager em, int id) {
        return em.find(Person.class, id);
    }

    static void update(EntityManager em, Person person) {
        em.getTransaction().begin();
        // Update
        em.merge(person);
        em.getTransaction().commit();
    }

    static void remove(EntityManager em, Person person) {
        em.getTransaction().begin();
        // Update
        em.remove(person);
        em.getTransaction().commit();
    }
}
