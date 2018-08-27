package de.nordakademie.iaa.roommanagement.action;

import de.nordakademie.iaa.roommanagement.dao.DAOFactory;
import de.nordakademie.iaa.roommanagement.model.Lecture;

import java.util.List;

public class ListLectureAction extends DatabaseAction {
    @Override
    public String getLabel() {
        return "Zeige Lextures an!";
    }

    @Override
    public void execute() throws Exception {
        List<Lecture> lectures = DAOFactory.createLectureDAO().listLectures();
        lectures.forEach(System.out::println);
    }
}
