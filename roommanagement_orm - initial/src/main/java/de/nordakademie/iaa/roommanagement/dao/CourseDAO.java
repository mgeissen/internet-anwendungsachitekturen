package de.nordakademie.iaa.roommanagement.dao;

import de.nordakademie.iaa.roommanagement.model.Course;
import de.nordakademie.iaa.roommanagement.model.Room;
import de.nordakademie.iaa.roommanagement.util.HibernateUtil;
import org.hibernate.exception.ConstraintViolationException;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import java.util.List;

public class CourseDAO {

    public static List<Course> listCourse() {
        EntityManager entityManager = HibernateUtil.getCurrentEntityManager();
        List<Course> courses = entityManager.createQuery("from Course ").getResultList();
        return courses;
    }

    public static Course showCourse(Long courseId) {
        EntityManager entityManager = HibernateUtil.getCurrentEntityManager();
        return entityManager.find(Course.class, courseId);
    }

    public static Course createCourse(Course course) {
        try {
            HibernateUtil.getCurrentEntityManager().persist(course);
        } catch (ConstraintViolationException exception) {
            throw new CourseAlreadyExistException();
        }
        return course;
    }

    public static void deleteCourse(Long courseId) {
        Course course = showCourse(courseId);
        HibernateUtil.getCurrentEntityManager().remove(course);
    }

}
