package de.nordakademie.iaa.roommanagement.service;

import de.nordakademie.iaa.roommanagement.dao.LectureDAO;
import de.nordakademie.iaa.roommanagement.model.Lecture;

import javax.inject.Inject;
import java.util.List;

public class LectureService {

    private LectureDAO lectureDAO;


    public Lecture createLecture(Lecture lecture) {
        return lectureDAO.createLecture(lecture);
    }

    public void deleteLecture(long lectureId) {
        lectureDAO.deleteLecture(lectureId);
    }

    public List<Lecture> listLectures() {
        return lectureDAO.listLectures();
    }

    public Lecture showLecture(long lectureId) {
        return lectureDAO.showLecture(lectureId);
    }

    @Inject
    public void setLectureDAO(LectureDAO lectureDAO) {
        this.lectureDAO = lectureDAO;
    }
}
