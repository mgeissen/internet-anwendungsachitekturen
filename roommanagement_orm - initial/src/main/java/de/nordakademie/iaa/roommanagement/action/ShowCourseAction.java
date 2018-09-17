package de.nordakademie.iaa.roommanagement.action;

import de.nordakademie.iaa.roommanagement.model.Course;
import de.nordakademie.iaa.roommanagement.util.ConsoleUtil;

public class ShowCourseAction extends DatabaseAction {
    @Override
    public String getLabel() {
        return "Zeige mir einen Kurs an!";
    }

    @Override
    public void execute() throws Exception {
        System.out.println("Wie heißt der Studiengang?");
        String fieldOfStudy = ConsoleUtil.readString();

        System.out.println("Welche Nummer hat die Vorlesung?");
        Integer roomNumber = ConsoleUtil.readInt();


        Course course = getCourseService().findByNaturalId(fieldOfStudy, roomNumber);
        System.out.println(course == null ? "RAUM NICHT GEFUNDEN" : course);
    }
}
