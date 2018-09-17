package de.nordakademie.iaa.roommanagement.action;

import de.nordakademie.iaa.roommanagement.util.ConsoleUtil;

public class DeleteLectureAction extends DatabaseAction {
    @Override
    public String getLabel() {
        return "Veranstaltung löschen!";
    }

    @Override
    public void execute() throws Exception {
        System.out.println("Geben Sie die Veranstaltungs ID an!");
        long lectureId = ConsoleUtil.readLong();
        getLectureService().deleteLecture(lectureId);
        System.out.printf("Die Veranstaltung mit der ID %1$d wurde gelöscht!", lectureId);
    }
}
