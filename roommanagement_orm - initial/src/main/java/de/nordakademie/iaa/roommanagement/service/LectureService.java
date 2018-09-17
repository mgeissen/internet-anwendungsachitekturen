package de.nordakademie.iaa.roommanagement.service;

import de.nordakademie.iaa.roommanagement.dao.LectureDAO;
import de.nordakademie.iaa.roommanagement.model.Lecture;

import javax.inject.Inject;
import java.util.List;

public class LectureService {

    private LectureDAO lectureDAO;

    public Lecture createLecture(Lecture lecture) {
        List<Lecture> lectures = lectureDAO.listLectures();

        long countLectureAtSameTime = lectures.stream()
                .filter(aLecture -> aLecture.getRoom().getId().equals(lecture.getRoom().getId()))
                .filter(aLecture -> aLecture.getEndDate().after(lecture.getStartDate()))
                .filter(aLecture -> aLecture.getStartDate().before(lecture.getEndDate()))
                .count();

        if(countLectureAtSameTime > 0) {
            return null;
        }
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
