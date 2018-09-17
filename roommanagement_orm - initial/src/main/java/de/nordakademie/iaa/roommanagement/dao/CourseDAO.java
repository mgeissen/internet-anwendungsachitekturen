package de.nordakademie.iaa.roommanagement.dao;

import de.nordakademie.iaa.roommanagement.model.Course;
import org.hibernate.exception.ConstraintViolationException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

public class CourseDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Course> listCourse() {
        List<Course> courses = entityManager.createQuery("from Course ").getResultList();
        return courses;
    }

    public Course showCourse(Long courseId) {
        return entityManager.find(Course.class, courseId);
    }

    public Course createCourse(Course course) {
        try {
            entityManager.persist(course);
        } catch (ConstraintViolationException exception) {
            throw new CourseAlreadyExistException();
        }
        return course;
    }

    public void deleteCourse(Long courseId) {
        Course course = showCourse(courseId);
        entityManager.remove(course);
    }

    public Course findByNaturalId(String fieldOfStudy, Integer number) {
        Query query = entityManager.createQuery(
                "select c from Course c where c.fieldOfStudy = :fieldOfStudy and c.number = :number");
        query.setParameter("fieldOfStudy", fieldOfStudy);
        query.setParameter("number", number);
        List<Course> resultList = query.getResultList();

        if (resultList.isEmpty()) {
            return null;
        } else {
            return resultList.get(0);
        }
    }

}
