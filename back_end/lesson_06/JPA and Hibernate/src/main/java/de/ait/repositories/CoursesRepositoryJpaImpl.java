package de.ait.repositories;

import de.ait.models.Course;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

/**
 * 10/9/2023
 * JPA and Hibernate
 *
 * @author Marsel Sidikov (AIT TR)
 */
public class CoursesRepositoryJpaImpl {

    private final EntityManager entityManager;

    public CoursesRepositoryJpaImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
        System.out.println(entityManager);
    }

    public void save(Course course) {
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();
        entityManager.persist(course);
        transaction.commit();
    }

    // получить список курсов, в котором заданное количество студентов
    public List<Course> findAllByStudentsCount(int count) {
        // HQL
        return entityManager.createQuery("select course from Course course where course.students.size = ?1",
                Course.class)
                .setParameter(1, count)
                .getResultList();
    }
}
