package de.nordakademie.iaa.roommanagement.action;

import de.nordakademie.iaa.roommanagement.model.Lecture;
import de.nordakademie.iaa.roommanagement.util.ConsoleUtil;

public class ShowLectureAction extends DatabaseAction {
    @Override
    public String getLabel() {
        return "Zeige Veranstaltung an!";
    }

    @Override
    public void execute() throws Exception {
        System.out.println("Welchen Veranstaltung soll angezeigt werden?");
        long lectureId = ConsoleUtil.readLong();

        Lecture lecture = getLectureService().showLecture(lectureId);
        System.out.println(lecture);
    }
}
