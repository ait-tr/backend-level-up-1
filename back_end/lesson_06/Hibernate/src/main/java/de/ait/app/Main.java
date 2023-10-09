package de.ait.app;

import de.ait.models.Course;
import de.ait.models.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * 10/9/2023
 * Hibernate
 *
 * @author Marsel Sidikov (AIT TR)
 */
public class Main {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate\\hibernate.cfg.xml");

        SessionFactory sessionFactory = configuration.buildSessionFactory();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction(); // begin transaction;

        Student student = session.get(Student.class, 1L);
        Course course = session.get(Course.class, 2L);

        student.getCourses().add(course);

        session.save(student);

        transaction.commit(); // commit;
        session.close();


        sessionFactory.close();
    }
}
