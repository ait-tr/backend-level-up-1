package de.ait.app;

import de.ait.models.Course;
import de.ait.repositories.CoursesRepositoryJpaImpl;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;

/**
 * 10/9/2023
 * JPA and Hibernate
 *
 * @author Marsel Sidikov (AIT TR)
 */
public class Main {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate\\hibernate.cfg.xml");

        SessionFactory sessionFactory = configuration.buildSessionFactory();

        EntityManager entityManager = sessionFactory.createEntityManager();

        CoursesRepositoryJpaImpl coursesRepository = new CoursesRepositoryJpaImpl(entityManager);

        System.out.println(coursesRepository.findAllByStudentsCount(2));
        System.out.println(coursesRepository.findAllByStudentsCount(3));

        sessionFactory.close();
    }
}
