package de.nordakademie.iaa.roommanagement.action;

import de.nordakademie.iaa.roommanagement.model.Lecture;

import java.util.List;

public class ListLectureAction extends DatabaseAction {
    @Override
    public String getLabel() {
        return "Zeige Lextures an!";
    }

    @Override
    public void execute() throws Exception {
        List<Lecture> lectures = getLectureService().listLectures();
        lectures.forEach(System.out::println);
    }
}
