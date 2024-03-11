package ru.anna.RestApiConsumer;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.anna.RestApiConsumer.entity.Passport;
import ru.anna.RestApiConsumer.entity.Person;


public class App {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class).addAnnotatedClass(Passport.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();

//            Person person = new Person("Tom",19); // добавление человека и паспорта
//            Passport passport = new Passport(4582830);
//            person.setPassport(passport); //с двух строн сразу связь после изменения метода
//            session.save(person);

//            Person person = session.get(Person.class,1);
//            System.out.println(person.getPassport().getPassportNumber());
//
//            Passport passport = session.get(Passport.class,2);
//            System.out.println(passport.getPerson().getName());

//            Person person = session.get(Person.class,1);
//            person.getPassport().setPassportNumber(567890); //меняем данные паспорта

            Person person = session.get(Person.class,1);
            session.remove(person);

            session.getTransaction().commit();

        } finally {
            sessionFactory.close();
        }
    }
}
