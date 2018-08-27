package de.nordakademie.iaa.roommanagement.dao;

import de.nordakademie.iaa.roommanagement.model.Lecture;
import de.nordakademie.iaa.roommanagement.util.HibernateUtil;
import org.hibernate.exception.ConstraintViolationException;

import javax.persistence.EntityManager;
import java.util.List;

public class LectureDAO {

    public List<Lecture> listLectures() {
        EntityManager entityManager = HibernateUtil.getCurrentEntityManager();
        List<Lecture> lectures = entityManager.createQuery("from Lecture ").getResultList();
        return lectures;
    }

    public Lecture showLecture(Long lectureId) {
        EntityManager entityManager = HibernateUtil.getCurrentEntityManager();
        return entityManager.find(Lecture.class, lectureId);
    }

    public Lecture createLecture(Lecture lecture) {
        try {
            HibernateUtil.getCurrentEntityManager().persist(lecture);
        } catch (ConstraintViolationException exception) {
            throw new CourseAlreadyExistException();
        }
        return lecture;
    }

    public void deleteLecture(Long lectureId) {
        Lecture lecture = showLecture(lectureId);
        HibernateUtil.getCurrentEntityManager().remove(lecture);
    }

}
