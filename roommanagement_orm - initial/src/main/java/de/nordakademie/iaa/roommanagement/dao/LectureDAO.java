package de.nordakademie.iaa.roommanagement.dao;

import de.nordakademie.iaa.roommanagement.model.Lecture;
import org.hibernate.exception.ConstraintViolationException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class LectureDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Lecture> listLectures() {
        List<Lecture> lectures = entityManager.createQuery("from Lecture ").getResultList();
        return lectures;
    }

    public Lecture showLecture(Long lectureId) {
        return entityManager.find(Lecture.class, lectureId);
    }

    public Lecture createLecture(Lecture lecture) {
        try {
            entityManager.persist(lecture);
        } catch (ConstraintViolationException exception) {
            throw new CourseAlreadyExistException();
        }
        return lecture;
    }

    public void deleteLecture(Long lectureId) {
        Lecture lecture = showLecture(lectureId);
        entityManager.remove(lecture);
    }

}
